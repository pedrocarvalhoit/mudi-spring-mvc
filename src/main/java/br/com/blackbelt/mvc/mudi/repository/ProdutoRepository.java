package br.com.blackbelt.mvc.mudi.repository;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.StatusProduto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Cacheable("test2")
    List<Produto> findAll();

    //Pageable cuida da ordenação das páginas -> @EnableCaching na application
    @Cacheable("test")
    List<Produto> findByStatus(StatusProduto status, Pageable sort);

    @Query("SELECT p from Produto p join p.user u where u.username = :username")
    //Param mapeia o username solicitado no método para a query
    List<Produto> findAllByUsuario(@Param("username") String username);

    @Query("SELECT p from Produto p join p.user u where u.username = :username and p.status = :status")
    List<Produto> findByStatusEUsuario(@Param("status") StatusProduto status, @Param("username")String username);


}
