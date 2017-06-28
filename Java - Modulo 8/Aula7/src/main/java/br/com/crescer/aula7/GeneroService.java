package br.com.crescer.aula7;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService{
    
    @Autowired
    GeneroRepositorio generoRepositorio;
    
    public Iterable<Genero> listar(){
        return generoRepositorio.findAll();
    }
}
