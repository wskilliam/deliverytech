package com.deliverytech.delivery_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "restaurantes") // Mapeia para a tabela "restaurantes" no banco de dados
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String categoria;

    private String endereco;

    private String telefone;

    private BigDecimal avalicao;

    @Column(name =" taxa_entrega")
    private BigDecimal taxaEntrega;

    private boolean ativo;

    @OneToMany(mappedBy = "restaurantes", fetch = FetchType.LAZY) // Relacionamento com produtos
    private List<Produto> produtos = new ArrayList<>();

    @OneToMany(mappedBy = "restaurantes", fetch = FetchType.LAZY) // Relacionamento com produtos
    private List<Pedido> pedidos = new ArrayList<>();


}

