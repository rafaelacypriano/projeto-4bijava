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
                () -> new RuntimeException(" A data não existe.")
        );

    }
    public void deletarRefeicaoPorData(Data data){
        repository.deleteByData(data);
    }

    public void atualizarRefeicaoPorId(Integer id, Refeicao refeicao ){
        Refeicao refeicaoEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Refeicao nao encontrada"));

        Refeicao refeicaoAtualizado = Refeicao.builder()
                .nome(refeicao.getNome() != null ? refeicao.getNome() : refeicaoEntity.getNome())
                .categoria(refeicao.getCategoria() != null ? refeicao.getCategoria() : refeicaoEntity.getCategoria())
                .descricao(refeicao.getDescricao() != null ? refeicao.getDescricao() : refeicaoEntity.getDescricao())
                .calorias(refeicao.getCalorias() != 0 ? refeicao.getCalorias() : refeicaoEntity.getCalorias())
                .data(refeicao.getData() != null ? refeicao.getData() : refeicaoEntity.getData())
                .id(refeicaoEntity.getId())
                .build();
            repository.saveAndFlush(refeicaoAtualizado);
    }




}
