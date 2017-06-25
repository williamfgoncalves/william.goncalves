package br.com.crescer.locadora_jpa.DAO;

import br.com.crescer.locadora_jpa.Models.Genero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class GeneroDao implements CrudDao <Genero, Long>{
    
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Locadora_JPA");
    final EntityManager manager = factory.createEntityManager();
    final Session session = manager.unwrap(Session.class);

    @Override
    public Genero save(Genero e) {
        session.getTransaction().begin();
        session.save(e);
        session.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Genero e) {
        session.getTransaction().begin();
        session.delete(e);
        session.getTransaction().commit();
    }

    @Override
    public Genero loadById(Long id) {
        Genero g;
        g = (Genero) session.get(Genero.class, id);
        return g;
    }

    @Override
    public List<Genero> findAll() {
        List<Genero> g;
        g = session.createCriteria(Genero.class).list();
        return g;
    }
    
    public void closeConnection() {
        manager.close();
        factory.close();
        //session.close();
    }
}
