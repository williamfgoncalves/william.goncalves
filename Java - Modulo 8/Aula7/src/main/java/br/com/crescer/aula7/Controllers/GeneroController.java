package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Genero;
import br.com.crescer.aula7.Services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
