
package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Funcionario;
import br.com.crescer.aula7.Services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}