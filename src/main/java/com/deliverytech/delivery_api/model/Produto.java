package com.deliverytech.delivery_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String descricao;

    private String categoria;

    private BigDecimal preco;

    private boolean disponivel;

    @ManyToOne(fetch = FetchType.LAZY) //fetch lazy para carregar sob demanda
    @JoinColumn(name = "restaurante_id") // Chave estrangeira para a tabela restaurantes
    private Restaurante restaurante;

}
