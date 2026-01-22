package com.deliverytech.delivery_api.repository;

import com.deliverytech.delivery_api.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository <ItemPedido, Long> {
    List<ItemPedido> findByPedidoId(Long pedidoId);
    List<ItemPedido> findByProdutoId(Long produtoId);
}
