package br.com.crescer.locadora_jpa.DAO;

import br.com.crescer.locadora_jpa.Models.Video;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class VideoDao implements CrudDao<Video, Long>{
    
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Locadora_JPA");
    final EntityManager manager = factory.createEntityManager();
    final Session session = manager.unwrap(Session.class);

    @Override
    public Video save(Video e) {
        session.getTransaction().begin();
        session.save(e);
        session.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Video e) {
        session.getTransaction().begin();
        session.delete(e);
        session.getTransaction().commit();
    }

    @Override
    public Video loadById(Long id) {
        Video v;
        v = (Video) session.get(Video.class, id);
        return v;
    }

    @Override
    public List<Video> findAll() {
        List<Video> v;
        v = session.createCriteria(Video.class).list();
        return v;
    }
    
    public void closeConnection() {
        manager.close();
        factory.close();
        //session.close();
    }
}
