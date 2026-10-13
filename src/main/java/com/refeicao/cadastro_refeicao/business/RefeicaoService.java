package com.refeicao.cadastro_refeicao.business;

import com.refeicao.cadastro_refeicao.infrastructure.entitys.Refeicao;
import com.refeicao.cadastro_refeicao.infrastructure.repository.RefeicaoRepository;
import org.springframework.stereotype.Service;

@Service
public class RefeicaoService {

    private final RefeicaoRepository repository;

    public RefeicaoService(RefeicaoRepository repository) {
        this.repository = repository;
    }

    public void salvarRefeicao(Refeicao refeicao) {
        repository.saveAndFlush(refeicao);
    }

    public Refeicao buscarRefeicaoPorCategoria(String categoria) {
        return repository.findByCategoria(categoria).orElseThrow(
                () -> new RuntimeException("A categoria não existe.")
        );
    }

    public void deletarRefeicaoPorCategoria(String categoria) {
        repository.deleteByCategoria(categoria);
    }

    public void atualizarRefeicaoPorId(Integer id, Refeicao refeicao) {
        Refeicao refeicaoEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Refeição não encontrada.")
        );

        Refeicao refeicaoAtualizada = Refeicao.builder()
                .nome(refeicao.getNome() != null ? refeicao.getNome() : refeicaoEntity.getNome())
                .categoria(refeicao.getCategoria() != null ? refeicao.getCategoria() : refeicaoEntity.getCategoria())
                .descricao(refeicao.getDescricao() != null ? refeicao.getDescricao() : refeicaoEntity.getDescricao())
                .calorias(refeicao.getCalorias() != 0 ? refeicao.getCalorias() : refeicaoEntity.getCalorias())
                .data(refeicao.getData() != null ? refeicao.getData() : refeicaoEntity.getData())
                .id(refeicaoEntity.getId())
                .build();

        repository.saveAndFlush(refeicaoAtualizada);
    }
}