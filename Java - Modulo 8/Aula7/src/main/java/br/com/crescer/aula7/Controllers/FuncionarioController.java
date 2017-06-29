
package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Funcionario;
import br.com.crescer.aula7.Services.FuncionarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping
    public Iterable<Funcionario> getFuncionario(){
        return funcionarioService.listar();
    }
    
    @PostMapping
    public Funcionario postCliente(@Valid @RequestBody Funcionario c){
        return funcionarioService.salvar(c);
    }
    
    @PutMapping
    public Funcionario putCliente(@Valid @RequestBody  Funcionario c){
        return funcionarioService.atualizar(c);
    }
    
    @DeleteMapping
    public void deleteCliente(Funcionario c){
        funcionarioService.remover(c);
    }
    
    @GetMapping("/{id}")
    public Funcionario getOneCliente(@PathVariable Long id){
        return funcionarioService.findById(id);
    }
}