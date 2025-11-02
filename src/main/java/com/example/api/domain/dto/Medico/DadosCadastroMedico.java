package com.example.api.domain.dto.Medico;

import com.example.api.domain.dto.DadosEndereco;
import com.example.api.domain.medico.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(@NotBlank String nome, @NotBlank @Email String email,
                                  @NotBlank @Pattern(regexp = "\\d{11}") String telefone,
                                  @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
                                  @NotNull Especialidade especialidade,
                                  @NotNull @Valid DadosEndereco endereco) {
}
