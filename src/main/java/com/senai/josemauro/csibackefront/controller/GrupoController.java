package com.senai.josemauro.csibackefront.controller;

import com.senai.josemauro.csibackefront.entidade.Grupo;
import com.senai.josemauro.csibackefront.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@CrossOrigin("*")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;


    @PostMapping
    public Grupo incluirGrupo(@RequestBody Grupo grupo){
        return grupoService.incluirGrupo(grupo);
    }

    @GetMapping
    public List<Grupo> listarGrupos(){
        return grupoService.listarGrupos();
    }

    @GetMapping("/{id}")
    public Grupo listarGrupoById(@PathVariable int id){
        return grupoService.listarGrupoById(id);
    }

    @PutMapping()
    public Grupo editarGrupo(@RequestBody Grupo grupo) {
        return grupoService.editarGrupo(grupo);
    }

    @DeleteMapping("/{id}")
    public void deletarGrupo(@PathVariable int id){
        grupoService.deletarGrupoById(id);
    }
}
