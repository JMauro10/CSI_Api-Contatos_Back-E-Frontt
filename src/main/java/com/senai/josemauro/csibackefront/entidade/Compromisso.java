package com.senai.josemauro.csibackefront.entidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "compromisso")
public class Compromisso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "titulo", length = 30, nullable = false)
    private String titulo;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Column(name = "dataHora", length = 100, nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "local", length = 30, nullable = false)
    private String local;

    @ManyToOne
    @JoinColumn(name = "contato_id")
    private Contato contato;

    public Compromisso() {
    }

    public Compromisso(int id, String titulo, String descricao, LocalDateTime dataHora, String local, Contato contato) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
