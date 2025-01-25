package br.ufba.tomorrow.todoProject.domain.services;

import br.ufba.tomorrow.todoProject.domain.entities.Todo;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.api.dto.TodoEstadoDto;
import br.ufba.tomorrow.todoProject.api.dto.TodoRequestDto;
import br.ufba.tomorrow.todoProject.api.dto.TodoResponseDto;
import br.ufba.tomorrow.todoProject.api.dto.TodoUpdateDto;
import br.ufba.tomorrow.todoProject.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto salvar(TodoRequestDto todoRequestDto) {
        return new TodoResponseDto(todoRepository.save(new Todo(todoRequestDto)));
    }

    public List<TodoResponseDto> listarTodosDeUmUsuario(long idUsuario) {
        return todoRepository.findByUsuario(new Usuario(idUsuario))
                .stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<TodoResponseDto> listarTodosDeUmUsuarioComEstado(Long idUsuario, Estado estado) {
        return todoRepository.findByUsuarioAndEstado(new Usuario(idUsuario), estado)
                .stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());
    }

    public Todo findById(long id) throws Exception {
        return todoRepository.findById(id).orElseThrow(
                () -> new Exception("Objeto nao encontrado com id " + id));
    }

    public TodoResponseDto alterar(TodoUpdateDto todoUpdateDto) throws Exception {
        Todo existe = findById(todoUpdateDto.getId());
        Todo inserir = new Todo(todoUpdateDto);
        inserir.setUsuario(existe.getUsuario());
        return new TodoResponseDto(todoRepository.save(inserir));
    }


    public TodoResponseDto alterarEstado(long id, TodoEstadoDto todoEstadoDto) throws Exception {
        Todo existe = findById(id);
        existe.setEstado(todoEstadoDto.getEstado());
        return new TodoResponseDto(existe);
    }

    public void deletar(long id) throws Exception {
        todoRepository.delete(findById(id));
    }
}
