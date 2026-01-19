package com.deliverytech.delivery_api.repository;

import com.deliverytech.delivery_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoRepository, Long> {
    List<Produto> findByRestaurantId(Long restauranteId); //filtra por restaurante
    List<Produto> findyByCategory(String categoria); //filtra por categoria
    List<Produto> findByAvailableTrue(); //filtra por disponivel
}
