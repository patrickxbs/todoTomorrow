package br.ufba.tomorrow.todoProject.domain.services;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.api.dto.UsuarioRequestDto;
import br.ufba.tomorrow.todoProject.api.dto.UsuarioResponseDto;
import br.ufba.tomorrow.todoProject.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDto criar(UsuarioRequestDto usuarioRequestDto) throws DataIntegrityViolationException {
        Usuario usuario = usuarioRepository.findByEmail(usuarioRequestDto.getEmail());
        if (usuario != null) throw new DataIntegrityViolationException
                ("Já existe usuário cadastrado com este email");
        usuarioRequestDto.setSenha(passwordEncoder.encode(usuarioRequestDto.getSenha()));
        System.out.println("Senha: " + usuarioRequestDto.getSenha());
        Usuario salvarUsuario = usuarioRepository.save(new Usuario(usuarioRequestDto));
        return new UsuarioResponseDto(salvarUsuario);
    }

}
