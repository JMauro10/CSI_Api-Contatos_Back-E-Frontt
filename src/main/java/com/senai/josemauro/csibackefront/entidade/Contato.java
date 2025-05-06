package com.senai.josemauro.csibackefront.entidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefone", length = 13)
    private String telefone;

    private Boolean favorito;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "contato_grupo",
            joinColumns = @JoinColumn(name = "contato_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private List<Grupo> grupos;

    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Compromisso> compromissos;


    public Contato() {
    }

    public Contato(int id, String nome, String email, String telefone, List<Grupo> grupos, List<Compromisso> compromissos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.grupos = new ArrayList<>(grupos);
        this.compromissos = new ArrayList<>(compromissos);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }
}