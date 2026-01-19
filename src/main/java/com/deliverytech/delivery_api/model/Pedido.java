package com.deliverytech.delivery_api.model;

import com.deliverytech.delivery_api.enums.StatusPedidos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedidos") // Mapeia para a tabela "pedidos" no banco de dados
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "endereco_entrega")
    private String enderecoEntrega;

    @Column(name = "numero_pedido")
    private String numeroPedido;

    @Column(name = "taxa_entrega")
    private BigDecimal taxaEntrega;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING) // Mapeia o enum como string no banco de dados
    private StatusPedidos status; //Status do pedido vem do enum StatusPedidos

    @ManyToOne(fetch = FetchType.LAZY) //fetch lazy para carregar sob demanda
    @JoinColumn(name = "cliente_id") // Chave estrangeira para a tabela clientes
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY) //fetch lazy para carregar sob demanda
    @JoinColumn(name = "restaurante_id") // Chave estrangeira para a tabela restaurantes
    private Restaurante restaurante;

    @OneToMany(mappedBy = "pedidos")
    private List<ItemPedido> itens = new ArrayList<>();
}
