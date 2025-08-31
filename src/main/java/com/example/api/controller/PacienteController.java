package com.example.api.controller;


import com.example.api.dto.DadosCadastroPaciente;
import com.example.api.model.Paciente;
import com.example.api.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pacientes")
@RestController
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

   @PostMapping
   @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
   }

}
