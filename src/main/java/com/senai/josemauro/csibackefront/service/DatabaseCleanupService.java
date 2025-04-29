package com.senai.josemauro.csibackefront.service;

import com.senai.josemauro.csibackefront.repository.ContatoRepository;
import com.senai.josemauro.csibackefront.repository.GrupoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseCleanupService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private GrupoRepository grupoRepository;

    // limpar os dados do banco
    @Transactional
    public void limparDados() {
        contatoRepository.deleteAll();
        grupoRepository.deleteAll();
    }
}
