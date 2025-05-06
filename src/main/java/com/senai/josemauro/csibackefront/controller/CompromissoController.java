package com.senai.josemauro.csibackefront.controller;


import com.senai.josemauro.csibackefront.entidade.Compromisso;
import com.senai.josemauro.csibackefront.entidade.Contato;
import com.senai.josemauro.csibackefront.service.CompromissoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compromisso")
@CrossOrigin("*")
public class CompromissoController {

    @Autowired
    private CompromissoService compromissoService;

    @GetMapping
    public List<Compromisso> listarCompromisso() {
        return compromissoService.listarCompromisso();
    }

    @GetMapping("/{id}")
    public Compromisso listarCompromissoById(@PathVariable int id) {
        return compromissoService.listarCompromissoById(id);
    }

    @PostMapping
    public Compromisso incluirCompromisso(@RequestBody Compromisso compromisso){
        return compromissoService.incluirCompromisso(compromisso);
    }

    @GetMapping("/contato/{contatoId}")
    public List<Compromisso> listarCompromissoPorContato(@PathVariable int idContato) {
        return compromissoService.listarCompromissosByContato(idContato);
    }

    @PutMapping
    public Compromisso alterarCompromissoByID(@RequestBody Compromisso compromisso) {
        return compromissoService.alterarCompromisso(compromisso);
    }

    @DeleteMapping("/{id}")
    public void deletarCompromissoById(@PathVariable int id){
        compromissoService.deletarCompromissoById(id);
    }

}
