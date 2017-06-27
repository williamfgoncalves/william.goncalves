package br.com.crescer.aula5_tema;

import br.com.crescer.locadora_jpa.DAO.GeneroDao;
import br.com.crescer.locadora_jpa.Models.Genero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GeneroBean {
    
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;
    private GeneroDao g = new GeneroDao();
    
    public Genero save(Genero genero) {
        return g.save(genero);
    }

    public List<Genero> findAll() {
        return g.findAll();
    }
    
    public void Remove(Long id){
        g.remove(g.loadById(id));
    }
    
    public Genero LoadById(Long id){
        return g.loadById(id);
    }
}
