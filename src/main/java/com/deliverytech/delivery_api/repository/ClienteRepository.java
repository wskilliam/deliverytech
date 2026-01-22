package com.deliverytech.delivery_api.repository;

import ch.qos.logback.core.net.server.Client;
import com.deliverytech.delivery_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { //ClienteRepository ele e uma interface
    Optional<Cliente> findByEmail(String email); //metodo para buscar cliente por email com se fosse select no sql

    boolean existsByEmail(String email);

    List<Cliente> findByAtivoTrue(); //metodo para buscar clientes ativos

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
