/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Amizade;
import br.com.crescer.social.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repository.UsuariosRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author William
 */
@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;
    @Autowired
    private AmizadesService amizadesService;

    public Iterable<Usuario> listarTodos() {
        return usuariosRepositorio.findAll();
    }

    public Usuario criar(Usuario s) {
        return usuariosRepositorio.save(s);
    }

    public Usuario update(Usuario s) {
        return usuariosRepositorio.save(s);
    }

    public void remover(Long id) {
        usuariosRepositorio.delete(id);
    }

    public Usuario buscarPorEmail(String email) {
        return usuariosRepositorio.findOneByEmail(email);
    }

    public List<Usuario> buscarUsuariosNaoAmigos(String email) {
        Usuario usuario = buscarPorEmail(email);
        List<Amizade> amizades = amizadesService.listarTodosPorIdUsuario(usuario.getIdusuario());
        Set<Long> amigos = amizades.stream().map(Amizade::getIdamigo).map(Usuario::getIdusuario).collect(toSet());
        amizades.stream().map(Amizade::getIdusuario).map(Usuario::getIdusuario).forEach(amigos::add);
        amigos.add(usuario.getIdusuario());
        return usuariosRepositorio.findByidusuarioNotIn(amigos.stream().collect(toList()));
    }
    
    public List<Usuario> buscarUsuarioPorNome(String nome) {
        return usuariosRepositorio.findByNomeContainingIgnoreCase(nome);
    }

    public void EncodePassWord(Usuario s) {
        String senha = new BCryptPasswordEncoder().encode(s.getSenha());
        s.setSenha(senha);
    }

    public void setImagem(Usuario s) {
        if (s.getUrlfoto() == null || s.getUrlfoto().isEmpty()) {
            if (s.getSexo().toString().contains("M")) {
                s.setUrlfoto("http://baxtercoaching.com/wp-content/uploads/2013/12/facebook-default-no-profile-pic-300x300.jpg");
            } else {
                s.setUrlfoto("http://rehrealestate.com/wp-content/uploads/2015/08/facebook-default-no-profile-pic-girl.jpg");
            }
        }
    }

    public Usuario getLogado() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(this::buscarPorEmail)
                .orElse(null);
    }
    
}
