package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Video;
import br.com.crescer.aula7.Services.VideoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/video")
public class VideoController {

    @Autowired
    private VideoService videoService;
    
    @GetMapping
    public Iterable<Video> getVideo() {
        return videoService.listar();
    }

    @PostMapping
    public Video postCliente(@Valid @RequestBody Video c){
        return videoService.salvar(c);
    }
    
    @PutMapping
    public Video putCliente(@Valid @RequestBody  Video c){
        return videoService.atualizar(c);
    }
    
    @DeleteMapping
    public void deleteCliente(Video c){
        videoService.remover(c);
    }
    
    @GetMapping("/{id}")
    public Video getOneCliente(@PathVariable Long id){
        return videoService.findById(id);
    }
}
