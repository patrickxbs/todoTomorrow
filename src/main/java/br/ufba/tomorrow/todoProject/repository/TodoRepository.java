package br.ufba.tomorrow.todoProject.repository;

import br.ufba.tomorrow.todoProject.domain.Todo;
import br.ufba.tomorrow.todoProject.domain.Usuario;
import br.ufba.tomorrow.todoProject.domain.status.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo save(Todo todo);

    List<Usuario> findByUsuario(Usuario usuario);

    List<Usuario> findByUsuarioAndEstado(Usuario usuario, Estado estado);
}
