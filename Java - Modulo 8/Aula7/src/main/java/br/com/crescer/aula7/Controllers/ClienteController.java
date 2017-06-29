package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Cliente;
import br.com.crescer.aula7.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
