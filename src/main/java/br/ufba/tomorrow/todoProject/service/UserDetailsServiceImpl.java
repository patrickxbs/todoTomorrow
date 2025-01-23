package br.ufba.tomorrow.todoProject.service;

import br.ufba.tomorrow.todoProject.domain.Usuario;
import br.ufba.tomorrow.todoProject.repository.UsuarioRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario currentUser = usuarioRepository.findByEmail(email);
        if (currentUser != null) {
            UserDetails userDetails = new org.springframework.security.core.
                    userdetails.User(email, currentUser.getSenha(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return userDetails;
        }
        else throw new UsernameNotFoundException("Usuario não encontrado!");
    }
}
