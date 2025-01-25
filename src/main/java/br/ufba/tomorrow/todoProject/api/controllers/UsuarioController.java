package br.ufba.tomorrow.todoProject.api.controllers;

import br.ufba.tomorrow.todoProject.api.dto.UsuarioRequestDto;
import br.ufba.tomorrow.todoProject.api.dto.UsuarioResponseDto;
import br.ufba.tomorrow.todoProject.domain.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criar(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto criar = usuarioService.criar(usuarioRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criar);
    }

}
