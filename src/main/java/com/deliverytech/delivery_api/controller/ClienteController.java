package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.dto.requests.ClienteDTO;
import com.deliverytech.delivery_api.dto.responses.ClienteResponseDTO;
import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<ClienteResponseDTO> cadastrar(@Valid @RequestBody ClienteDTO cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(cliente));
    }

    @GetMapping("/listar")
    public List<ClienteResponseDTO> listar(){
        return service.listarAtivos();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

//    @PutMapping("/{id}")
//    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente novosDados){
//        return service.atualizar(id, novosDados);
//    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<ClienteResponseDTO> toggleAtivo(@PathVariable Long id){
        return ResponseEntity.ok(service.toggleAtivo(id));
    }
}
