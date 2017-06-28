/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author william.goncalves
 */
public class Run {

    public static void main(String[] args) {
        
        // INICIALIZACAO IGUAL PARA O JPA E O HIBERNATE, A UNICA DIFERNECA E NO SESSION QUE HABILITA O HIBERNATE
        // TEMOS TAMBEM QUE ALTERAR O POM E O PERSSISTENCE
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();
        Session session = em.unwrap(Session.class);
        
        final Cliente cliente = new Cliente();
        cliente.setID(14L);
        cliente.setNome("Willliam");
        
        em.getTransaction().begin();
        session.save(cliente);
        em.getTransaction().commit();
        
        //session.close();
        em.close();
        emf.close();
        
        /* METODOS ABAIXO SAO USADOS NO JPA
        em.getTransaction().begin(); // abrindo transacao
        final Cliente cliente = new Cliente(); // instancia um novo cliente
        cliente.setId(1l); // passando valores por parametro
        cliente.setNome("William");
        em.persist(cliente); // persistinfo dado no banco
        em.getTransaction().commit(); // comitando transacao
        
        final Cliente cliente2 = em.find(Cliente.class, 1L); // Busca Cliente do banco
        System.out.println("Cliente " + cliente.getNome());
        cliente.setId(1l); // passando valores por parametro
        cliente.setNome("Eduardo");
        
        em.getTransaction().begin();
        em.merge(cliente);//dando o upadte do campo
        em.getTransaction().commit();;
        
        em.getTransaction().begin();
        em.remove(cliente); // Deletando cliente
        em.getTransaction().commit();

        em.close();
        emf.close();*/
    }
}
