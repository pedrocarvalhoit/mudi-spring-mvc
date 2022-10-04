package br.com.blackbelt.mvc.mudi.repository;

import br.com.blackbelt.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PedidoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pedido> recuperaTodosOsPedidos(){
        Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class); //Cita qual classe buscar
        return query.getResultList();
    }

}
