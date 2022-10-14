package br.com.blackbelt.mvc.mudi.repository;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.StatusProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByStatus(StatusProduto statusProduto);
}
