
package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Usuarios;
import br.com.crescer.aula7.Services.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public Iterable<Usuarios> getUsuarios(){
        return service.listarTodos();
    }
    
    @PostMapping
    public Usuarios createUsuario(@Valid @RequestBody Usuarios s){
        return service.criar(s);
    }
}
