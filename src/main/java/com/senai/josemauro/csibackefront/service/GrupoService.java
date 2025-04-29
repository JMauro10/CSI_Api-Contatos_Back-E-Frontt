package com.senai.josemauro.csibackefront.service;


import com.senai.josemauro.csibackefront.entidade.Contato;
import com.senai.josemauro.csibackefront.entidade.Grupo;
import com.senai.josemauro.csibackefront.repository.ContatoRepository;
import com.senai.josemauro.csibackefront.repository.GrupoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return grupoRepository.save(grupo);
    }

    public Grupo editarGrupo(Grupo grupo) {
        if (!grupoRepository.existsById(grupo.getId())) {
            throw new RuntimeException("Grupo " + grupo.getId() + " não encontrado!");
        }
        return grupoRepository.save(grupo);
    }

    public void deletarGrupoById(int id) {
        grupoRepository.deleteById(id);
    }
}
