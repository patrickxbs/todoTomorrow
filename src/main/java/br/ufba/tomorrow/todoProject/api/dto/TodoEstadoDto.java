package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;

public class TodoEstadoDto {

    private Estado estado;

    public TodoEstadoDto() {
    }

    public TodoEstadoDto(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEsado(Estado estado) {
        this.estado = estado;
    }
}
