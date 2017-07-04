/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Amizade;
import br.com.crescer.social.Models.Usuario;
import br.com.crescer.social.repository.AmizadesRepositorio;
import br.com.crescer.social.repository.UsuariosRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William
 */
@Service
public class AmizadesService {

    @Autowired
    private AmizadesRepositorio amizadesRepositorio;
    @Autowired
    private UsuariosRepositorio repositorio;
    @Autowired UsuariosService usuariosService; 
    
    public Iterable<Amizade> listar() {
        return amizadesRepositorio.findAll();
    }
    
    public List<Amizade> listarTodosPorIdUsuario(Long Id){
        Usuario u = repositorio.findOne(Id);
        return amizadesRepositorio.findAllByidusuario(u);
    }
    
    public List<Amizade> listarAmizadesUsuario(String email) {
        Usuario u = repositorio.findOneByEmail(email);
        List<Amizade> amigos = amizadesRepositorio.findByidusuario(u);
        List<Amizade> amigosPendentes = new ArrayList<>();
        for (Amizade amigo : amigos) {
            if (amigo.getSituacao().toString().contains("A")) {
                amigosPendentes.add(amigo);
            }
        }
        return amigosPendentes;
    }

    public List<Amizade> listarConvitesAmizadesUsuario(String email) {
        Usuario u = repositorio.findOneByEmail(email);
        List<Amizade> amigos = amizadesRepositorio.findByidusuario(u);
        List<Amizade> amigosPendentes = new ArrayList<>();
        for (Amizade amigo : amigos) {
            if (amigo.getSituacao().toString().contains("P")) {
                amigosPendentes.add(amigo);
            }
        }
        return amigosPendentes;
    }

    public Amizade createSolicitacaoAmizade(Long amigo) {
        Usuario u = usuariosService.getLogado();
        Usuario a = repositorio.findOne(amigo);
        Amizade amigos = new Amizade();
        
        amigos.setIdusuario(a);
        amigos.setIdamigo(u);
        amigos.setSituacao('P');
        return amizadesRepositorio.save(amigos);
    }
    
    public Amizade aceitarAmizade(Long idamizade){
        Amizade a = amizadesRepositorio.findOne(idamizade);
        a.setSituacao('A');
        Usuario amigo = a.getIdamigo();
        Usuario user = a.getIdusuario();
        amizadesRepositorio.save(a);
        
        Amizade b = new Amizade();
        b.setIdamizade(a.getIdamizade()+1);
        b.setSituacao('A');
        b.setIdamigo(user);
        b.setIdusuario(amigo);
        return amizadesRepositorio.save(b);
    }
}
