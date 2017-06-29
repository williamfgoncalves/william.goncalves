package br.com.crescer.aula7.Repositories;

import br.com.crescer.aula7.Models.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long> {
    
}
