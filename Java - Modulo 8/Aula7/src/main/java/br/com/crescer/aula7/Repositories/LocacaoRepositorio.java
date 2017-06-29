
package br.com.crescer.aula7.Repositories;

import br.com.crescer.aula7.Models.Locacao;
import org.springframework.data.repository.CrudRepository;

public interface LocacaoRepositorio extends CrudRepository<Locacao, Long> {
    
}
