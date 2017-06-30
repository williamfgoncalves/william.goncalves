/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.Repositories;

import br.com.crescer.aula7.Models.Amizades;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author William
 */
public interface AmizadesRepositorio extends CrudRepository<Amizades, Long>{
    
}
