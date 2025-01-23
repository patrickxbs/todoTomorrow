package br.ufba.tomorrow.todoProject.domain;

import br.ufba.tomorrow.todoProject.dto.UsuarioRequestDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Todo> todoList;

    public Usuario() {
    }

    public Usuario(UsuarioRequestDto usuarioRequestDto) {
        this.email = usuarioRequestDto.getEmail();
        this.senha = usuarioRequestDto.getSenha();
    }

    public Usuario(Long id, String email, String senha, List<Todo> todoList) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.todoList = todoList;
    }

    public Usuario(Long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
