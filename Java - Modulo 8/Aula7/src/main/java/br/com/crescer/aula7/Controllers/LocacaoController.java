package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Locacao;
import br.com.crescer.aula7.Services.LocacaoService;
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
@RequestMapping(value = "/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping
    public Iterable<Locacao> getLocacao() {
        return locacaoService.listar();
    }
    
    @PostMapping
    public Locacao postCliente(@Valid @RequestBody Locacao c){
        return locacaoService.salvar(c);
    }
    
    @PutMapping
    public Locacao putCliente(@Valid @RequestBody  Locacao c){
        return locacaoService.atualizar(c);
    }
    
    @DeleteMapping
    public void deleteCliente(Locacao c){
        locacaoService.remover(c);
    }
    
    @GetMapping("/{id}")
    public Locacao getOneCliente(@PathVariable Long id){
        return locacaoService.findById(id);
    }
}
