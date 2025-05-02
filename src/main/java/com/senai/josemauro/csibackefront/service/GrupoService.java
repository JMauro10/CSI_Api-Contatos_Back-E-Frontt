package com.senai.josemauro.csibackefront.service;


import com.senai.josemauro.csibackefront.entidade.Contato;
import com.senai.josemauro.csibackefront.entidade.Grupo;
import com.senai.josemauro.csibackefront.repository.ContatoRepository;
import com.senai.josemauro.csibackefront.repository.GrupoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> listarGrupos() {
            return  grupoRepository.findAll();
    }

    public Grupo listarGrupoById(int id) {
        return grupoRepository.findById(id).orElseThrow(()-> new RuntimeException("Grupo " + id + " não encontrado"));
    }

    public Grupo incluirGrupo(Grupo grupo) {
        if(grupoRepository.existsByNome(grupo.getNome())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já exite um grupo com esse nome: " + grupo.getNome());
        }
        return grupoRepository.save(grupo);
    }

    public Grupo editarGrupo(Grupo grupo) {
        if(grupoRepository.existsByNome(grupo.getNome())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já exite um grupo com esse nome: " + grupo.getNome());
        }
        return grupoRepository.save(grupo);
    }

    public void deletarGrupoById(int id) {
        grupoRepository.deleteById(id);
    }
}
