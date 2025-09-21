package com.example.api.controller;


import com.example.api.dto.AtualizarDadosMedico;
import com.example.api.dto.DadosCadastroMedico;
import com.example.api.dto.DadosListagemMedico;
import com.example.api.model.Medico;
import com.example.api.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemMedico> medicos = medicoRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new);
        return ResponseEntity.status(HttpStatus.OK).body(medicos);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarDadosMedico dados) {
       var medico = medicoRepository.getReferenceById(dados.id());
       medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        medicoRepository.deleteById(id);
        medico.excluir();
    }

}
