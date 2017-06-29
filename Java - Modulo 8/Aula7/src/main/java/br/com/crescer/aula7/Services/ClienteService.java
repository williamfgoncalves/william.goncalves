package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Models.Cliente;
import br.com.crescer.aula7.Repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Iterable<Cliente> listar(){
        return clienteRepositorio.findAll();
    }
}
