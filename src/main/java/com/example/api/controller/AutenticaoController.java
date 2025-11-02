package com.example.api.controller;


import com.example.api.domain.dto.DadosAutenticacao;
import com.example.api.domain.usuario.Usuario;
import com.example.api.domain.usuario.UsuarioRepository;
import com.example.api.infra.security.DadosTokenJWT;
import com.example.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var AuthenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var authentication = authenticationManager.authenticate(AuthenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }
}
