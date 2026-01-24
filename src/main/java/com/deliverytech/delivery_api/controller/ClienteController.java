package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
        return ResponseEntity.status(201).body(service.cadastrar(cliente));
    }

    @GetMapping("/listar")
    public List<Cliente> listar(){
        return service.listarAtivos();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente novosDados){
        return service.atualizar(id, novosDados);
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id){
        service.desativar(id);
        return ResponseEntity.noContent().build();
    }
}
