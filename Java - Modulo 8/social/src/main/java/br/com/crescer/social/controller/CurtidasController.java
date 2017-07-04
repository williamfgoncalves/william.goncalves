/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.Models.Curtida;
import br.com.crescer.social.service.CurtidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William
 */
@RestController
@RequestMapping(value = "/curtidas")
public class CurtidasController {
    
    @Autowired
    private CurtidasService curtidasService;
    
    @GetMapping
    public Iterable<Curtida> getCurtidas(){
        return curtidasService.listar();
    }
    @PostMapping
    public Curtida criarCurtida(@RequestParam String email, @RequestParam Long idpostagem){
        return curtidasService.cadastrar(email, idpostagem);
    }
}
