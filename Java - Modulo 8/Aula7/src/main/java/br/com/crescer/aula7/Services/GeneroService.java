package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Models.Genero;
import br.com.crescer.aula7.Repositories.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService{
    
    @Autowired
    private GeneroRepositorio generoRepositorio;
    
    public Iterable<Genero> listar(){
        return generoRepositorio.findAll();
    }
}
