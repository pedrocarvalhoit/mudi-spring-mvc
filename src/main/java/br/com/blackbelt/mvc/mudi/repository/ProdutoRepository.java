package br.com.blackbelt.mvc.mudi.repository;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.StatusProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByStatus(StatusProduto status);

    @Query("SELECT p from Produto p join p.user u where u.username = :username")
    //Param mapeia o username solicitado no método para a query
    List<Produto> findAllByUsuario(@Param("username") String username);

    @Query("SELECT p from Produto p join p.user u where u.username = :username and p.status = :status")
    List<Produto> findByStatusEUsuario(@Param("status") StatusProduto status, @Param("username")String username);


}
