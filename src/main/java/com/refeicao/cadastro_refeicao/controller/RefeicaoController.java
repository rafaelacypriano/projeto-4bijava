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
}



