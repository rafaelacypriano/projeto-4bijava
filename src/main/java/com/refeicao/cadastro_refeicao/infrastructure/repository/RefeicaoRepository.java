package com.refeicao.cadastro_refeicao.infrastructure.repository;

import com.refeicao.cadastro_refeicao.infrastructure.entitys.Refeicao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Integer> {


    Optional<Refeicao> findByData(LocalDate data);

    @Transactional
    void deleteByData(LocalDate data);


    Optional<Refeicao> findByCategoria(String categoria);

    @Transactional
    void deleteByCategoria(String categoria);
}