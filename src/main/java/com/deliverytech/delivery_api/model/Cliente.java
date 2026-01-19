package com.deliverytech.delivery_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "clientes") // Mapeia para a tabela "clientes" no banco de dados
public class Cliente { // Classe de modelo para Cliente
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gerarção automática do ID
    private Long id;

    private String nome; // Nome do cliente

    @Column(unique = true, nullable = false) // Email único e não nulo
    private String email; // Email do cliente

    private String telefone; // Telefone do cliente

    private String endereco; // Endereço do cliente

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro; // Data de cadastro do cliente

    private boolean ativo; // Status do cliente (ativo/inativo)

    @OneToMany(mappedBy = "clientes") // Relacionamento com pedidos
    private List<Pedido> pedidos = new ArrayList<>(); // Lista de pedidos do cliente

    /* Sem Lombok */

    // Getters e Setters gerado pelo Lombok, mas aqui estão para referência

}

