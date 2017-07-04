/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.Models.Amizade;
import br.com.crescer.social.Models.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author William
 */
public interface AmizadesRepositorio extends CrudRepository<Amizade, Long> {
    
    public List<Amizade> findByidusuario(Usuario u);
    
    public List<Amizade> findAllByIdusuarioOrIdamigoAndSituacao(Usuario usuario, Usuario amigo, Character a);

    public List<Amizade> findAllByIdusuarioOrIdamigo(Usuario usuario, Usuario amigo);
}
