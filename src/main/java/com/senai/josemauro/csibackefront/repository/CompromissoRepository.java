package com.senai.josemauro.csibackefront.repository;

import com.senai.josemauro.csibackefront.entidade.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Integer> {

    boolean existsByTitulo(String titulo);

    boolean existsByDataHora(LocalDateTime dataHora);

    boolean existsByTituloAndIdNot(String titulo, int id);

    boolean existsByDataHoraAndIdNot(LocalDateTime dataHora, int id);


}
