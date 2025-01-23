package br.ufba.tomorrow.todoProject.controller;

import br.ufba.tomorrow.todoProject.domain.status.Estado;
import br.ufba.tomorrow.todoProject.dto.TodoEstadoDto;
import br.ufba.tomorrow.todoProject.dto.TodoRequestDto;
import br.ufba.tomorrow.todoProject.dto.TodoResponseDto;
import br.ufba.tomorrow.todoProject.dto.TodoUpdateDto;
import br.ufba.tomorrow.todoProject.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> criar(@RequestBody TodoRequestDto todoRequestDto) {
        TodoResponseDto salvar = todoService.salvar(todoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TodoResponseDto>> listarPorUsuario(@PathVariable long idUsuario) {
        List<TodoResponseDto> todoResponseDtos = todoService.listarTodosDeUmUsuario(idUsuario);
        return ResponseEntity.ok(todoResponseDtos);
    }

    @GetMapping("/{idUsuario}/{estado}")
    public ResponseEntity<List<TodoResponseDto>> listarPorUsuarioEEstado(@PathVariable long id, @PathVariable Estado estado) {
        List<TodoResponseDto> todoResponseDtos = todoService.listarTodosDeUmUsuarioComEstado(id, estado);
        return ResponseEntity.ok(todoResponseDtos);
    }

    @PutMapping
    public ResponseEntity<TodoResponseDto> alterar(@RequestBody TodoUpdateDto todoUpdateDto) throws Exception {
        TodoResponseDto alterar = todoService.alterar(todoUpdateDto);
        return ResponseEntity.ok(alterar);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> alterarEstado(@PathVariable long id, @RequestBody TodoEstadoDto todoEstadoDto)
            throws Exception {
        TodoResponseDto alterarEstado = todoService.alterarEstado(id, todoEstadoDto);
        return ResponseEntity.ok(alterarEstado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) throws Exception {
        todoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
