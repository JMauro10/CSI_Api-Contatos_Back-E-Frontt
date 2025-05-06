package com.senai.josemauro.csibackefront.service;

import com.senai.josemauro.csibackefront.RegraNegocioException;
import com.senai.josemauro.csibackefront.entidade.Contato;
import com.senai.josemauro.csibackefront.entidade.Grupo;
import com.senai.josemauro.csibackefront.repository.ContatoRepository;
import com.senai.josemauro.csibackefront.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private GrupoRepository grupoRepository;

    public List<Contato> listarContato(){
        return contatoRepository.findAll();
    }

    public Contato listarByIdContato(int id) {
        return contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    public List<Contato> listarContatosByGrupo(int idGrupo) {
        Grupo grupo = grupoRepository.findById(idGrupo).
                orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        return grupo.getContatos();
    }

    public Contato incluirContato(Contato contato) {
        if ((contato.getEmail() == null || contato.getEmail().isBlank()) &&
                (contato.getTelefone() == null || contato.getTelefone().isBlank())) {
            throw new IllegalArgumentException("É necessário um e-mail e ou telefone");
        }
        if(contato.getGrupos() != null){
            List<Grupo> grupos = grupoRepository.findAllById(contato.getGrupos().stream().map(Grupo::getId).toList());
            contato.setGrupos(grupos);
        }
        if(contatoRepository.existsByNome(contato.getNome())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já exite um contato com esse nome: " + contato.getNome());
        }
        if(contatoRepository.existsByEmail(contato.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já exite um contato com esse email: " + contato.getEmail());
        }
        return contatoRepository.save(contato);
    }

    public Contato alterarContato(Contato contato) {
        if (contatoRepository.existsByNomeAndIdNot(contato.getNome(), contato.getId())) {
            throw new RegraNegocioException("Já existe um contato com esse nome!");
        }

        if (contatoRepository.existsByEmailAndIdNot(contato.getEmail(), contato.getId())) {
            throw new RegraNegocioException("Já existe um contato com esse email!");
        }

        if (contato.getGrupos() != null) {
            List<Grupo> grupos = grupoRepository.findAllById(
                    contato.getGrupos().stream()
                            .map(Grupo::getId)
                            .toList()
            );
            contato.setGrupos(grupos);
        }
        return contatoRepository.save(contato);
    }

    public void deletarByIdContato(int id) {
        contatoRepository.deleteById(id);
    }
    public void atualizarFavorito(int id, boolean favorito) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Contato não encontrado"));
        contato.setFavorito(favorito);
        contatoRepository.save(contato);
    }

}
