package com.deliverytech.delivery_api.dto.responses;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteResponseDTO {

    private String nome;

    private String categoria;

    private String endereco;

    private String telefone;

    private BigDecimal avaliacao; // ou Double, conforme sua escolha

    private BigDecimal taxaEntrega;

    private boolean ativo;

}
