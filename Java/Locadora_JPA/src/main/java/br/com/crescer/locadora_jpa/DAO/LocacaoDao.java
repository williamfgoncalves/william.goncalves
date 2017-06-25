package br.com.crescer.locadora_jpa.DAO;

import br.com.crescer.locadora_jpa.Models.Locacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class LocacaoDao implements CrudDao<Locacao, Long>{
    
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Locadora_JPA");
    final EntityManager manager = factory.createEntityManager();
    final Session session = manager.unwrap(Session.class);
    
    @Override
    public Locacao save(Locacao e) {
        session.getTransaction().begin();
        session.save(e);
        session.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Locacao e) {
        session.getTransaction().begin();
        session.delete(e);
        session.getTransaction().commit();
    }

    @Override
    public Locacao loadById(Long id) {
        Locacao l;
        l = (Locacao) session.get(Locacao.class, id);
        return l;
    }

    @Override
    public List<Locacao> findAll() {
        List<Locacao> l;
        l = session.createCriteria(Locacao.class).list();
        return l;
    }
    
    public void closeConnection() {
        manager.close();
        factory.close();
        //session.close();
    }
}
