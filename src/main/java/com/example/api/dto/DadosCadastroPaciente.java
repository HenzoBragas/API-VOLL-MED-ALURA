package com.example.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank  String nome, @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotBlank @Pattern(regexp = "\\d{11}") String telefone,
        @NotNull @Valid DadosEndereco endereco) {
}
