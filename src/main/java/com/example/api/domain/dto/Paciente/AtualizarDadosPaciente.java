package com.example.api.domain.dto.Paciente;

import com.example.api.domain.dto.DadosEndereco;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizarDadosPaciente(
        @NotNull Long id,
        String nome,
        @Pattern(regexp = "\\d{11}") String telefone,
        DadosEndereco endereco) {
}
