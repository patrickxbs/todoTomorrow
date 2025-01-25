package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;

import java.time.LocalDate;

public class TodoRequestDto {

    Long idUsuario;

    String item;

    LocalDate prazo;

    Estado estado;

    public TodoRequestDto() {
    }

    public TodoRequestDto(Long idUsuario, String item, LocalDate prazo, Estado estado) {
        this.idUsuario = idUsuario;
        this.item = item;
        this.prazo = prazo;
        this.estado = estado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
