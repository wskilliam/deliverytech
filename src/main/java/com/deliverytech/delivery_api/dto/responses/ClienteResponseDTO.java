package com.deliverytech.delivery_api.dto.responses;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClienteResponseDTO {
    private String nome;

    private String email;

    private String telefone;

    private String endereco;

    private boolean ativo;

    private LocalDateTime dataCadastro;
}
