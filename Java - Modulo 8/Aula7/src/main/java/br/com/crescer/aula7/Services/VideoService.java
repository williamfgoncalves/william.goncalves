package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Models.Video;
import br.com.crescer.aula7.Repositories.VideoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Autowired
    private VideoRepositorio videoRepositorio;
    
    public Iterable<Video> listar(){
        return videoRepositorio.findAll();
    }
}
