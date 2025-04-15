package com.senai.josemauro.csibackefront.service;

import com.senai.josemauro.csibackefront.entidade.Contato;
import com.senai.josemauro.csibackefront.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato incluirContato(Contato contato) {
        if ((contato.getEmail() == null || contato.getEmail().isBlank()) &&
                (contato.getTelefone() == null || contato.getTelefone().isBlank())) {
            throw new IllegalArgumentException("É necessário um e-mail ou telefone");
        }
        return contatoRepository.save(contato);
    }

    public List<Contato> listarContato(){
        return contatoRepository.findAll();
    }

    public Contato listarByIdContato(Integer id) {
        return contatoRepository.findById(id).orElse(null);
    }
    public void deletarByIdContato(int id) {
        contatoRepository.deleteById(id);
    }
}
