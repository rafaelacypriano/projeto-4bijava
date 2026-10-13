package com.refeicao.cadastro_refeicao.controller;

import com.refeicao.cadastro_refeicao.business.RefeicaoService;
import com.refeicao.cadastro_refeicao.infrastructure.entitys.Refeicao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refeicao")
@RequiredArgsConstructor
public class RefeicaoController {

    private final RefeicaoService refeicaoService;

    @PostMapping
    public ResponseEntity<Void> salvarRefeicao (@RequestBody Refeicao refeicao) {
        refeicaoService.salvarRefeicao(refeicao);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Refeicao> buscarRefeicaoPorCategoria(@RequestParam String categoria){
        return ResponseEntity.ok(refeicaoService.buscarRefeicaoPorCategoria(categoria));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarRefeicaoPorCategoria(@RequestParam String categoria){
        refeicaoService.deletarRefeicaoPorCategoria((categoria));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarRefeicaoPorId(@RequestBody Refeicao refeicao,
                                                    @RequestParam Integer id){
        refeicaoService.atualizarRefeicaoPorId(id, refeicao);
        return ResponseEntity.ok().build();
    }

}



