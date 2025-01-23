package br.ufba.tomorrow.todoProject.dto;

import br.ufba.tomorrow.todoProject.domain.status.Estado;

import java.time.LocalDate;

public class TodoUpdateDto {

    private long id;
    private String item;
    private LocalDate prazo;
    private Estado estado;
    private LocalDate conclusao;

    public TodoUpdateDto() {
    }

    public TodoUpdateDto(long id, String item, LocalDate prazo, Estado estado, LocalDate conclusao) {
        this.id = id;
        this.item = item;
        this.prazo = prazo;
        this.estado = estado;
        this.conclusao = conclusao;
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

    public LocalDate getConclusao() {
        return conclusao;
    }

    public void setConclusao(LocalDate conclusao) {
        this.conclusao = conclusao;
    }
}
