/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.Models.Amizades;
import br.com.crescer.social.service.AmizadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William
 */
@RestController
@RequestMapping(value = "/amizades")
public class AmizadesController {
    
    @Autowired
    private AmizadesService amizadesService;
    
    @GetMapping
    public Iterable<Amizades> getAmizades(){
        return amizadesService.listar();
    }
}

