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
    
    public Cliente salvar(Cliente c){
        return clienteRepositorio.save(c);
    }
    
    public Cliente atualizar(Cliente c){
        return clienteRepositorio.save(c);
    }
    
    public void remover(Cliente c){
        clienteRepositorio.delete(c);
    }
    
    public Cliente findById(Long id){
        return clienteRepositorio.findOne(id);
    }
}
