package com.example.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizarDadosMedico(
        @NotNull  Long id,
         String nome,
        @Pattern(regexp = "\\d{11}") String telefone,
         DadosEndereco endereco) {
}
