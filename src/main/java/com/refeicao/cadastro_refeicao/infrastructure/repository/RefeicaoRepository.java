package com.refeicao.cadastro_refeicao.infrastructure.repository;

import com.refeicao.cadastro_refeicao.infrastructure.entitys.Refeicao;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Integer> {

    Optional<Refeicao> findByData(Data data);

    @Transactional // se der erro, nao pode deletar
    void deleteByData(Data data);



}
