/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.Models.Amizade;
import br.com.crescer.social.service.AmizadesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Iterable<Amizade> getAmizades(){
        return amizadesService.listar();
    }
    
    @GetMapping(value = "/amigos")
    public List<Amizade> getAmizadesUsuario(@RequestParam String email){
        return amizadesService.listarAmizadesUsuario(email);
    }
    
    @GetMapping(value = "/pendentes")
    public List<Amizade> getAmizadesPendentesUsuario(@RequestParam String email){
        return amizadesService.listarConvitesAmizadesUsuario(email);
    }
    
    @PostMapping(value = "/solicitaramizade/{id}")
    public Amizade postAmizade(@PathVariable Long id){
        return amizadesService.createSolicitacaoAmizade(id);
    }
    
    @PutMapping(value = "/aceitaramizade/{id}")
    public Amizade putAmizade(@PathVariable Long id){
        return amizadesService.aceitarAmizade(id);
    }
    
    @DeleteMapping(value = "/removeramizade")
    public void removerAmizade(@RequestParam Long idamizade){
        amizadesService.rejeitarAmizade(idamizade);
    }
}

