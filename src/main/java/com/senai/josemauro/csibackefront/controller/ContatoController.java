package com.senai.josemauro.csibackefront.controller;

import com.senai.josemauro.csibackefront.entidade.Contato;
import com.senai.josemauro.csibackefront.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@CrossOrigin("*")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> listarContato() {
        return contatoService.listarContato();
    }

    @GetMapping("/{id}")
    public Contato listarContatoById(@PathVariable int id) {
        return contatoService.listarByIdContato(id);
    }

    @PostMapping
    public Contato incluirContato(@RequestBody Contato contato){
        return contatoService.incluirContato(contato);
    }

    @GetMapping("/grupo/{grupoId}")
    public List<Contato> listarContatosPorGrupo(@PathVariable int idGrupo) {
        return contatoService.listarContatosByGrupo(idGrupo);
    }

    @PutMapping
    public Contato alterarContato(@RequestBody Contato contato) {
        return contatoService.alterarContato(contato);
    }

    @DeleteMapping("/{id}")
    public void deletarContatoById(@PathVariable int id){
        contatoService.deletarByIdContato(id);
    }
}