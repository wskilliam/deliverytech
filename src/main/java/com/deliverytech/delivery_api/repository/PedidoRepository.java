package com.deliverytech.delivery_api.repository;

import com.deliverytech.delivery_api.enums.StatusPedidos;
import com.deliverytech.delivery_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClientId(Long clienteId);
    List<Pedido> findByStatus(StatusPedidos status); //filtra por status do pedido pelo enum StatusPedidos
    @Query("""
        SELECT p FROM Pedido p //seleciona pedido p
        WHERE p.dataPedido BETWEEN :inicio AND :fim //filtra por data do pedido entre inicio e fim
        """)
    List<Pedido> findByDataTime(
            @Param("inicio")LocalDateTime inicio,
            @Param("fim")LocalDateTime fim
            );
}
