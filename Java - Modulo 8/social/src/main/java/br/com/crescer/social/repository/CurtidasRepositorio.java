/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.Models.Curtida;
import org.springframework.data.repository.CrudRepository;


public interface CurtidasRepositorio extends CrudRepository<Curtida, Long> {
    
}
