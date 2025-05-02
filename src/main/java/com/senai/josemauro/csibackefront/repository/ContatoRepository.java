package com.senai.josemauro.csibackefront.repository;

import com.senai.josemauro.csibackefront.entidade.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    boolean existsByNome(String nome);

    boolean existsByEmail(String email);

    boolean existsByNomeAndIdNot(String nome, int id);

    boolean existsByEmailAndIdNot(String email, int id);
}
