/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repository.UsuariosRepositorio;

/**
 *
 * @author William
 */
@Service
public class UsuariosService{
    
    @Autowired
    private UsuariosRepositorio usuariosRepositorio;
    
    public Iterable<Usuarios> listarTodos(){
        return usuariosRepositorio.findAll();
    }
    
    public Usuarios criar(Usuarios s){
        return usuariosRepositorio.save(s);
    }
    
    public void remover(Long id){
        usuariosRepositorio.delete(id);
    }
    
    public Usuarios buscarPorId(Long Id){
        return usuariosRepositorio.findOne(Id);
    }
}
