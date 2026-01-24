package com.deliverytech.delivery_api.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurantes") // Mapeia para a tabela "restaurantes" no banco de dados
public class Restaurante {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    private String endereco;

    private String telefone;

    @Column(name = "avaliacao") // <-- nome da coluna correto no banco
    private BigDecimal avaliacao; // ou Double, conforme sua escolha

    @Column(name = "taxa_entrega")
    private BigDecimal taxaEntrega;

    private boolean ativo;

    @OneToMany(mappedBy="restaurante", fetch= FetchType.LAZY)
    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();

    @OneToMany(mappedBy="restaurante", fetch= FetchType.LAZY)
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();

}