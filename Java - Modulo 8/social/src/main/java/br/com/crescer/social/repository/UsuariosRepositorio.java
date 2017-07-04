/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.Models.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author William
 */
public interface UsuariosRepositorio extends CrudRepository<Usuario, Long> {
    public Usuario findOneByEmail(String email);

    public List<Usuario> findByidusuarioNotIn(List<Long> amigos);
}
