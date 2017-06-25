package br.com.crescer.locadora_jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class FuncionarioDao implements CrudDao< Funcionario, Long> {

    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Locadora_JPA");
    final EntityManager manager = factory.createEntityManager();
    final Session session = manager.unwrap(Session.class);
    
    @Override
    public Funcionario save(Funcionario e) {
        session.getTransaction().begin();
        session.save(e);
        session.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Funcionario e) {
        session.getTransaction().begin();
        session.delete(e);
        session.getTransaction().commit();
    }

    @Override
    public Funcionario loadById(Long id) {
        Funcionario f;
        f = (Funcionario) session.get(Funcionario.class, id);
        return f;
    }

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> f;
        f = session.createCriteria(Funcionario.class).list();
        return f;
    }

    public void closeConnection() {
        manager.close();
        factory.close();
        //session.close();
    }
}
