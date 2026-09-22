package com.refeicao.cadastro_refeicao.business;

import com.refeicao.cadastro_refeicao.infrastructure.entitys.Refeicao;
import com.refeicao.cadastro_refeicao.infrastructure.repository.RefeicaoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

public class RefeicaoService {
    private final RefeicaoRepository repository;

    public RefeicaoService(RefeicaoRepository repository){
        this.repository = repository;
    }
    public void salvarRefeicao(Refeicao refeicao){
        repository.saveAndFlush(refeicao);
    }
    public Refeicao buscarRefeicaoPorData(Data data){
        return repository.findByData(data).orElseThrow(
                () -> new RuntimeException("data nao encontrada")
        )

    }


}
