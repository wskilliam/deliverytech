package com.deliverytech.delivery_api.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteDTO {

    @NotNull
    @NotBlank
    private String nome;

    @NotBlank
    private String Categoria;

    @Size(max = 255)
    private String endereco;

    @NotBlank
    private BigDecimal avaliacao;

    @NotBlank
    private BigDecimal taxaEntrega;
}
