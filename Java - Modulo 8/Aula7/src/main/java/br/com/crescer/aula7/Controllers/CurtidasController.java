/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Curtidas;
import br.com.crescer.aula7.Services.CurtidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Iterable<Curtidas> getCurtidas(){
        return curtidasService.listar();
    }
}
