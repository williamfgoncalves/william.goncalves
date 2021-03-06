/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.Models.Postagem;
import br.com.crescer.social.service.PostagensService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William
 */
@RestController
@RequestMapping(value = "/postagem")
public class PostagensController {

    @Autowired
    private PostagensService postagensService;

    @GetMapping
    public Iterable<Postagem> getPostagens() {
        return postagensService.listarTodos();
    }
    
    @GetMapping(value = "/post")
    public Iterable<Postagem> getPostagensPorUsuario(@RequestParam String email) {
        return postagensService.listarPorIdUsuario(email);
    }
    
    @GetMapping(value = "/postAmigos")
    public List<Postagem> getPostagensAmigoUser(@RequestParam String email){
        return postagensService.listarPostagemAmigos(email);
    }

    @PostMapping(consumes = "application/json")
    public Postagem createUsuario(@Valid @RequestBody Postagem p) {
        return postagensService.criar(p);
    }
}
