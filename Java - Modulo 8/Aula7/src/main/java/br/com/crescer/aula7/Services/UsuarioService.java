
package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Models.Usuarios;
import br.com.crescer.aula7.Repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio repositorio;
    
    public Iterable<Usuarios> listarTodos(){
        return repositorio.findAll();
    }
    
    public Usuarios criar(Usuarios s){
        return repositorio.save(s);
    }
    
    public void remover(Long id){
        repositorio.delete(id);
    }
    
    public Usuarios buscarPorId(Long Id){
        return repositorio.findOne(Id);
    }
}
