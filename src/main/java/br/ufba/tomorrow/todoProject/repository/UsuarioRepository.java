package br.ufba.tomorrow.todoProject.repository;

import br.ufba.tomorrow.todoProject.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario save(Usuario usuario);

    Usuario findByEmail(String email);

}
