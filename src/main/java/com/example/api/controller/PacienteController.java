package com.example.api.controller;


import com.example.api.domain.dto.Paciente.AtualizarDadosPaciente;
import com.example.api.domain.dto.Paciente.DadosCadastroPaciente;
import com.example.api.domain.dto.Paciente.DadosDetalhamentoPaciente;
import com.example.api.domain.dto.Paciente.DadosListagemPaciente;
import com.example.api.domain.Paciente.Paciente;
import com.example.api.domain.Paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        Page<DadosListagemPaciente> paciente = pacienteRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemPaciente::new);
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> detalhar(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new DadosDetalhamentoPaciente(paciente));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody AtualizarDadosPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarDadosPacientes(dados);
        return ResponseEntity.status(HttpStatus.OK).body(new DadosListagemPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }


}
