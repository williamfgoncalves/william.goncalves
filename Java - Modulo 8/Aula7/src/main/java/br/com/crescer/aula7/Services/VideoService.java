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
    
    public Video salvar(Video c){
        return videoRepositorio.save(c);
    }
    
    public Video atualizar(Video c){
        return videoRepositorio.save(c);
    }
    
    public void remover(Video c){
        videoRepositorio.delete(c);
    }
    
    public Video findById(Long id){
        return videoRepositorio.findOne(id);
    }
}
