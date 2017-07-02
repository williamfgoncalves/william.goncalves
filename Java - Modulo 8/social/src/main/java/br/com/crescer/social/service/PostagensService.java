/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Postagem;
import br.com.crescer.social.repository.PostagensRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William
 */
@Service
public class PostagensService {
    @Autowired
    private PostagensRepositorio postagensRepositorio;
    
    public Postagem criar(Postagem p){
        return postagensRepositorio.save(p);
    }
    
    public Iterable<Postagem> listarTodos() {
        return postagensRepositorio.findAll();
    }
}
