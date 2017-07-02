/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.Models.Usuario;
import br.com.crescer.social.service.UsuariosService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William
 */
@RestController
@RequestMapping(value="/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService service;
    
    @GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }

    @GetMapping(value = "/login")
    public Usuario login(@RequestParam String email) {
        return service.buscarPorEmail(email);
    }
    
    @PostMapping(consumes = "application/json")
    public Usuario createUsuario(@Valid @RequestBody Usuario s){
        service.EncodePassWord(s);
        service.setImagem(s);
        return service.criar(s);
    }
    
    @PutMapping
    public Usuario updateUsuario(@Valid @RequestBody Usuario s){
        service.EncodePassWord(s);
        service.setImagem(s);
        return service.update(s);
    }
}

