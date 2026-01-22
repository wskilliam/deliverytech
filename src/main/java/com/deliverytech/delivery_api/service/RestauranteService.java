package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RestauranteService {
    private final RestauranteRepository repository;

    public RestauranteService(RestauranteRepository repository){
        this.repository = repository;
    }

    public Restaurante cadastrar(Restaurante dados){
        dados.setAtivo(true);
        return repository.save(dados);
    }

    public List<Restaurante> listarAtivos(){
        return repository.findByAtivoTrue();
    }

    public List<Restaurante> buscarPorCategoria(String categoria){
        return repository.findByCategoriaAndAtivoTrue(categoria);
    }

    public Restaurante buscaPorId(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Restaurante não encontrado. "));
    }

    public void desativar(Long id){
        Restaurante restaurante = buscaPorId(id);
        restaurante.setAtivo(false);
        repository.save(restaurante);
    }
}
