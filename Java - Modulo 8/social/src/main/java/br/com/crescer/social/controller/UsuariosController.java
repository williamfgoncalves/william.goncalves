/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.Models.Usuarios;
import br.com.crescer.social.service.UsuariosService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Iterable<Usuarios> getUsuarios(){
        return service.listarTodos();
    }
    
    @PostMapping
    public Usuarios createUsuario(@Valid @RequestBody Usuarios s){
        return service.criar(s);
    }
}

