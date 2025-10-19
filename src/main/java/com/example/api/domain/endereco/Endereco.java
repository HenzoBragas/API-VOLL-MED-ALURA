package com.example.api.domain.endereco;

import com.example.api.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }
    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro() != null) {
            this.logradouro = logradouro;
        }
        if(dados.bairro() != null) {
            this.bairro = bairro;
        }
        if(dados.cep() != null) {
            this.cep = cep;
        }
        if(dados.numero() != null) {
            this.numero = numero;
        }
        if(dados.complemento() != null) {
            this.complemento = complemento;
        }
        if(dados.cidade() != null) {
            this.cidade = cidade;
        }
        if(dados.uf() != null) {
            this.uf = uf;
        }
    }

}