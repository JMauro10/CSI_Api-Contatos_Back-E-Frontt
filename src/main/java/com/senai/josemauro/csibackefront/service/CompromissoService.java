package com.senai.josemauro.csibackefront.service;


import com.senai.josemauro.csibackefront.RegraNegocioException;
import com.senai.josemauro.csibackefront.entidade.Compromisso;
import com.senai.josemauro.csibackefront.entidade.Contato;
import com.senai.josemauro.csibackefront.repository.CompromissoRepository;
import com.senai.josemauro.csibackefront.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompromissoService {

    @Autowired
    private CompromissoRepository compromissoRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Compromisso> listarCompromisso(){
        return compromissoRepository.findAll();
    }

    public Compromisso listarCompromissoById(int id) {
        return compromissoRepository.findById(id).orElseThrow(() -> new RuntimeException("Compromisso não encontrado"));
    }

    public List<Compromisso> listarCompromissosByContato(int idContato) {
        Contato contato = contatoRepository.findById(idContato).
                orElseThrow(() -> new RuntimeException("Compromissos não encontrado"));
        return contato.getCompromissos();
    }

    public Compromisso incluirCompromisso(Compromisso compromisso) {
        if ((compromisso.getTitulo() == null && (compromisso.getDataHora() == null))){
            throw new IllegalArgumentException("É necessário um título, data e horário!");
        }
        if(compromissoRepository.existsByTitulo(compromisso.getTitulo())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já exite um compromisso com esse título: " + compromisso.getTitulo());
        }
        if(compromissoRepository.existsByDataHora((compromisso.getDataHora()))){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já exite um compromisso com nessa data: " + compromisso.getDataHora());
        }
        return compromissoRepository.save(compromisso);
    }

    public Compromisso alterarCompromisso(Compromisso compromisso) {
        if (compromissoRepository.existsByTituloAndIdNot(compromisso.getTitulo(), compromisso.getId())) {
            throw new RegraNegocioException("Já existe um compromisso com esse título!");
        }
        if (compromissoRepository.existsByDataHoraAndIdNot((compromisso.getDataHora()), compromisso.getId())) {
            throw new RegraNegocioException("Já existe um compromisso nessa data e horário!");
        }

        if (compromisso.getContato() != null && compromisso.getContato().getId() > 0) {
            Contato contato = contatoRepository.findById(compromisso.getContato().getId())
                    .orElseThrow(() -> new RegraNegocioException("Contato não encontrado"));
            compromisso.setContato(contato);
        }
        return compromissoRepository.save(compromisso);
    }

    public void deletarCompromissoById(int id) {
        compromissoRepository.deleteById(id);
    }
}
