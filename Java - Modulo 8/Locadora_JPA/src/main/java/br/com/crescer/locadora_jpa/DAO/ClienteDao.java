package br.com.crescer.locadora_jpa.DAO;

import br.com.crescer.locadora_jpa.Models.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class ClienteDao implements CrudDao<Cliente, Long>{
    
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Locadora_JPA");
    final EntityManager manager = factory.createEntityManager();
    final Session session = manager.unwrap(Session.class);

    @Override
    public Cliente save(Cliente e) {
        session.getTransaction().begin();
        session.save(e);
        session.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Cliente e) {
        session.getTransaction().begin();
        session.delete(e);
        session.getTransaction().commit();
    }

    @Override
    public Cliente loadById(Long id) {
        Cliente c;
        c = (Cliente) session.get(Cliente.class, id);
        return c;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> c;
        c = session.createCriteria(Cliente.class).list();
        return c;
    }
    
    public void closeConnection() {
        manager.close();
        factory.close();
        //session.close();
    }
}
