package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Models.Locacao;
import br.com.crescer.aula7.Services.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
