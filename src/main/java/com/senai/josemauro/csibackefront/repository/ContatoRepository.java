package com.senai.josemauro.csibackefront.repository;

import com.senai.josemauro.csibackefront.entidade.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
