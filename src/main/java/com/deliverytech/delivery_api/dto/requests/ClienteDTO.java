package com.deliverytech.delivery_api.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//DTOs Cliente recebem os dados do cliente, como nome, email, telefone, etc.
// Eles são usados para transferir dados entre as camadas da aplicação,
// como entre o controlador e o serviço. O DTO ajuda a encapsular os dados e a
// evitar a exposição direta das entidades do banco de dados, promovendo
// uma melhor organização e segurança na aplicação.
public class ClienteDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email inválido")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}", message ="Telefone inválido. Formato esperado: (XX) XXXXX-XXXX ou (XX) XXXX-XXXX")
    private String telefone;

    @Size(min = 5, message = "Endereço deve ter ao menos 5 caracteres")
    private String endereco;
}
