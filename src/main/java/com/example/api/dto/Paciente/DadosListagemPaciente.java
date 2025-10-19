package com.example.api.dto.Paciente;

import com.example.api.domain.Paciente.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf, String telefone) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
