package com.senai.josemauro.csibackefront.repository;

import com.senai.josemauro.csibackefront.entidade.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
}
