
package br.com.crescer.aula7.Repositories;

import br.com.crescer.aula7.Models.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepositorio extends CrudRepository<Video, Long> {
}
