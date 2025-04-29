package com.senai.josemauro.csibackefront.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome", length = 50)
    private String nome;

    @ManyToMany(mappedBy = "grupos")
    @JsonIgnore
    private List<Contato> contatos;

    public Grupo() {
    }

    public Grupo(int idGrupo, String nome, List<Contato> contatos) {
        this.id = idGrupo;
        this.nome = nome;
        this.contatos = new ArrayList<>(contatos);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
