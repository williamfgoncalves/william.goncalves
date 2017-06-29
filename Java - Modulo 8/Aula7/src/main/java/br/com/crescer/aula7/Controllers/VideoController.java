package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Video;
import br.com.crescer.aula7.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
