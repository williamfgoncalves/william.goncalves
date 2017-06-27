package br.com.crescer.aula5_tema;

import br.com.crescer.locadora_jpa.DAO.FuncionarioDao;
import br.com.crescer.locadora_jpa.Models.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FuncionarioBean {
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;
    private FuncionarioDao f = new FuncionarioDao();
    
    public Funcionario save(Funcionario funcionario) {
        return f.save(funcionario);
    }

    public List<Funcionario> findAll() {
        return f.findAll();
    }
}
