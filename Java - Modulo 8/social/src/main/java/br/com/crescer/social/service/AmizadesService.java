/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.Models.Amizades;
import br.com.crescer.social.repository.AmizadesRepositorio;
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
    
    public Iterable<Amizades> listar(){
       return amizadesRepositorio.findAll();
   }
}
