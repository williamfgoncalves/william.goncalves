
package br.com.crescer.aula7.Repositories;

import br.com.crescer.aula7.Models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{
    
}
