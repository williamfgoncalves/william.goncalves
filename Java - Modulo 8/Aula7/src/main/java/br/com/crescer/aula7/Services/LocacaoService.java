package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Models.Locacao;
import br.com.crescer.aula7.Repositories.LocacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepositorio locacaoRepositorio;
    
    public Iterable<Locacao> listar(){
        return locacaoRepositorio.findAll();
    }
    
    public Locacao salvar(Locacao c){
        return locacaoRepositorio.save(c);
    }
    
    public Locacao atualizar(Locacao c){
        return locacaoRepositorio.save(c);
    }
    
    public void remover(Locacao c){
        locacaoRepositorio.delete(c);
    }
    
    public Locacao findById(Long id){
        return locacaoRepositorio.findOne(id);
    }
}
