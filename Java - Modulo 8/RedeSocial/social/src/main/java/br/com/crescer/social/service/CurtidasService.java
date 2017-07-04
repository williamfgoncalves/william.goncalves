/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Curtida;
import br.com.crescer.social.Models.Postagem;
import br.com.crescer.social.Models.Usuario;
import br.com.crescer.social.repository.CurtidasRepositorio;
import br.com.crescer.social.repository.PostagensRepositorio;
import br.com.crescer.social.repository.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author William
 */

@Service
public class CurtidasService {
    
    @Autowired
    private CurtidasRepositorio curtidasRepositorio;
    @Autowired
    private UsuariosRepositorio repositorio;
    @Autowired
    private PostagensRepositorio postagensRepositorio;
    
    public Iterable<Curtida> listar(){
        return curtidasRepositorio.findAll();
    }
    public Curtida cadastrar(String email, Long idpostagem){
        Usuario u = repositorio.findOneByEmail(email);
        Postagem p = postagensRepositorio.findOne(idpostagem);
        Curtida c =  new Curtida();
        c.setIdpostagem(p);
        c.setIdusuario(u);
        return curtidasRepositorio.save(c);
    }
}
