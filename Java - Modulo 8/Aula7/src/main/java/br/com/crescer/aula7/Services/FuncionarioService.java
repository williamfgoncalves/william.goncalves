
package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Models.Funcionario;
import br.com.crescer.aula7.Repositories.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;
    
    public Iterable<Funcionario> listar(){
        return funcionarioRepositorio.findAll();
    }
}
