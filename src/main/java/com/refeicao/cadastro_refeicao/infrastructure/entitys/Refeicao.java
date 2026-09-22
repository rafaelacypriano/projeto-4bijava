package com.refeicao.cadastro_refeicao.infrastructure.entitys;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "refeicao")
@Entity

public class Refeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "calorias")
    private int calorias;

    @Column(name = "data")
    private Data data;

}
