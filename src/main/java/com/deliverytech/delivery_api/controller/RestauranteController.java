package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.service.RestauranteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Restaurante> cadastrar(@RequestBody Restaurante dados){
        return ResponseEntity.status(201).body(service.cadastrar(dados));
    }

    @GetMapping
    public List<Restaurante> listar(){
        return service.listarAtivos();
    }

    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable Long id){
        return service.buscaPorId(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Restaurante> buscarPorCategoria(@PathVariable String categoria){
        return service.buscarPorCategoria(categoria);
    }


    @DeleteMapping("/{id}")
    public void desativar(@PathVariable Long id){
        service.desativar(id);
    }
}
