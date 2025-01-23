package br.ufba.tomorrow.todoProject.domain;

import br.ufba.tomorrow.todoProject.domain.status.Estado;
import br.ufba.tomorrow.todoProject.dto.TodoEstadoDto;
import br.ufba.tomorrow.todoProject.dto.TodoRequestDto;
import br.ufba.tomorrow.todoProject.dto.TodoUpdateDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String item;

    private LocalDate prazo;

    private Estado estado;

    private LocalDate conclusao;

    public Todo() {
    }

    public Todo(Long id, Usuario usuario, String item, LocalDate prazo, Estado estado, LocalDate conclusao) {
        this.id = id;
        this.usuario = usuario;
        this.item = item;
        this.prazo = prazo;
        this.estado = estado;
        this.conclusao = conclusao;
    }

    public Todo(TodoRequestDto todoRequestDto) {
        setUsuario(new Usuario(todoRequestDto.getIdUsuario()));
        setItem(todoRequestDto.getItem());
        setPrazo(todoRequestDto.getPrazo());
        setEstado(todoRequestDto.getEstado());
    }

    public Todo(TodoUpdateDto todoUpdateDto) {
        this.item = todoUpdateDto.getItem();
        this.prazo = todoUpdateDto.getPrazo();
        this.estado = todoUpdateDto.getEstado();
        this.conclusao = todoUpdateDto.getConclusao();
        this.id = todoUpdateDto.getId();
    }

    public Todo(TodoEstadoDto todoEstadoDto) {
        this.estado = todoEstadoDto.getEstado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
