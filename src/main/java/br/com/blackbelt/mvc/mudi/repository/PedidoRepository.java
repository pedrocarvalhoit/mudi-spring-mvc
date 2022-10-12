package br.com.blackbelt.mvc.mudi.repository;

import br.com.blackbelt.mvc.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

}
