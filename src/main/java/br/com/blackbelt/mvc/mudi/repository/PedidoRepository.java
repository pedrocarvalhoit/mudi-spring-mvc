package br.com.blackbelt.mvc.mudi.repository;

import br.com.blackbelt.mvc.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

}
