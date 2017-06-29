
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
    
    public Funcionario salvar(Funcionario c){
        return funcionarioRepositorio.save(c);
    }
    
    public Funcionario atualizar(Funcionario c){
        return funcionarioRepositorio.save(c);
    }
    
    public void remover(Funcionario c){
        funcionarioRepositorio.delete(c);
    }
    
    public Funcionario findById(Long id){
        return funcionarioRepositorio.findOne(id);
    }
}
