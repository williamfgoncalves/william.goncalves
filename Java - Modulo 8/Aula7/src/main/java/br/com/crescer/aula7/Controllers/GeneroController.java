package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Genero;
import br.com.crescer.aula7.Services.GeneroService;
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
@RequestMapping(value = "/genero")
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @GetMapping
    public Iterable<Genero> getGenero(){
        return generoService.listar();
    }
    
    @PostMapping
    public Genero postCliente(@Valid @RequestBody Genero c){
        return generoService.salvar(c);
    }
    
    @PutMapping
    public Genero putCliente(@Valid @RequestBody  Genero c){
        return generoService.atualizar(c);
    }
    
    @DeleteMapping
    public void deleteCliente(Genero c){
        generoService.remover(c);
    }
    
    @GetMapping("/{id}")
    public Genero getOneCliente(@PathVariable Long id){
        return generoService.findById(id);
    }
}
