package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Cliente;
import br.com.crescer.aula7.Services.ClienteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public Iterable<Cliente> getCliente() {
        return clienteService.listar();
    }
    
    @PostMapping
    public Cliente postCliente(@Valid @RequestBody Cliente c){
        return clienteService.salvar(c);
    }
    
    @PutMapping
    public Cliente putCliente(@Valid @RequestBody  Cliente c){
        return clienteService.atualizar(c);
    }
    
    @DeleteMapping
    public void deleteCliente(Cliente c){
        clienteService.remover(c);
    }
    
    @GetMapping("/{id}")
    public Cliente getOneCliente(@PathVariable Long id){
        return clienteService.findById(id);
    }
}
