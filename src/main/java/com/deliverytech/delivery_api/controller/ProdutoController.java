package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.deliverytech.delivery_api.model.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/{restauranteId}")
    public ResponseEntity<Produto> cadastrar(@PathVariable Long restauranteId, @RequestBody Produto produto){
        return ResponseEntity.status(201).body(produtoService.cadastrar(restauranteId, produto));
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<Produto> listarPorRestaurante(@PathVariable Long restauranteId){
        return produtoService.listarPorRestaurante(restauranteId);
    }
}
