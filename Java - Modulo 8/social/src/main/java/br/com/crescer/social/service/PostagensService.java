/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Amizade;
import br.com.crescer.social.Models.Postagem;
import br.com.crescer.social.Models.Usuario;
import br.com.crescer.social.repository.AmizadesRepositorio;
import br.com.crescer.social.repository.PostagensRepositorio;
import java.util.List;
import java.util.stream.Collectors;
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
    @Autowired
    private UsuariosService service;

    @Autowired
    private AmizadesRepositorio amizadesRepositorio;

    public Postagem criar(Postagem p) {
        return postagensRepositorio.save(p);
    }

    public List<Postagem> listarPostagemAmigos(String email) {
        Usuario u = service.buscarPorEmail(email);
        List<Long> ids = amizadesRepositorio.findByidusuario(u).stream()
                .map(Amizade::getIdamigo)
                .map(Usuario::getIdusuario)
                .collect(Collectors.toList());
                ids.add(u.getIdusuario());
        return postagensRepositorio.findByIdusuario_idusuarioIn(ids);
    }

    public Iterable<Postagem> listarTodos() {
        return postagensRepositorio.findAll();
    }

    public Iterable<Postagem> listarPorIdUsuario(String email) {
        Usuario u = service.buscarPorEmail(email);
        return postagensRepositorio.findByidusuario(u);
    }
}
