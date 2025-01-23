package br.ufba.tomorrow.todoProject.dto;

import br.ufba.tomorrow.todoProject.domain.Todo;
import br.ufba.tomorrow.todoProject.domain.Usuario;
import br.ufba.tomorrow.todoProject.domain.status.Estado;

import java.time.LocalDate;

public class TodoResponseDto {

    private long id;
    private String item;
    private LocalDate prazo;
    private Estado estado;

    public TodoResponseDto() {
    }

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.item = todo.getItem();
        this.prazo = todo.getPrazo();
        this.estado = todo.getEstado();
    }

    public TodoResponseDto(Usuario usuario) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
