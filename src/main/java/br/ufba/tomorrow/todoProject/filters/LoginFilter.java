package br.ufba.tomorrow.todoProject.filters;

import br.ufba.tomorrow.todoProject.domain.Usuario;
import br.ufba.tomorrow.todoProject.service.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        Usuario usuario = new ObjectMapper()
                .readValue(request.getInputStream(), Usuario.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                usuario.getEmail(), usuario.getSenha(), Collections.emptyList()));
    }

    protected void sucessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                           FilterChain chain, Authentication auth) throws IOException, ServletException{
        AuthenticationService.addToken(response, auth.getName());
    }
}


