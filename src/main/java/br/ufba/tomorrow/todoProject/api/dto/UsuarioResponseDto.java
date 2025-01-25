package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;

public class UsuarioResponseDto {

    private Long id;
    private String email;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
