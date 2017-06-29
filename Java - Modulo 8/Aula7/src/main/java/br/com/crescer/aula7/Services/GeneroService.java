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
    
    public Genero salvar(Genero c){
        return generoRepositorio.save(c);
    }
    
    public Genero atualizar(Genero c){
        return generoRepositorio.save(c);
    }
    
    public void remover(Genero c){
        generoRepositorio.delete(c);
    }
    
    public Genero findById(Long id){
        return generoRepositorio.findOne(id);
    }
}
