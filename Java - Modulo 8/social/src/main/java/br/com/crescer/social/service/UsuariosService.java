/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repository.UsuariosRepositorio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author William
 */
@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    public Iterable<Usuario> listarTodos() {
        return usuariosRepositorio.findAll();
    }

    public Usuario criar(Usuario s) {
        return usuariosRepositorio.save(s);
    }
    
    public Usuario update(Usuario s){
        return usuariosRepositorio.save(s);
    }

    public void remover(Long id) {
        usuariosRepositorio.delete(id);
    }

    public Usuario buscarPorEmail(String email) {
        return usuariosRepositorio.findOneByEmail(email);
    }

    public void EncodePassWord(Usuario s) {
        String senha = new BCryptPasswordEncoder().encode(s.getSenha());
        s.setSenha(senha);
    }

    public void setImagem(Usuario s) {
        if ( s.getUrlfoto() == null || s.getUrlfoto().isEmpty()){
            if (s.getSexo().toString().contains("M")) {
                s.setUrlfoto("http://baxtercoaching.com/wp-content/uploads/2013/12/facebook-default-no-profile-pic-300x300.jpg");
            } else {
                s.setUrlfoto("http://rehrealestate.com/wp-content/uploads/2015/08/facebook-default-no-profile-pic-girl.jpg");
            }
        }
    }
}
