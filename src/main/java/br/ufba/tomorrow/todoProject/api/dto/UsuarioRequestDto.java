package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDto {

    @Email(message = "O email não é válido")
    private String email;

    @Size(min = 5, max = 20, message = "A senha deve ter entre 5 a 20 caracteres")
    private String senha;

    public UsuarioRequestDto() {
    }

    public UsuarioRequestDto(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
