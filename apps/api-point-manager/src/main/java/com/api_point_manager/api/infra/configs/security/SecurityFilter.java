package com.api_point_manager.api.infra.configs.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api_point_manager.api.infra.persistence.repositories.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                var JWTToken = getHeaderBearerToken(request);
                if(JWTToken != null){
                    var tokenSubject = tokenService.getSubject(JWTToken);
                    var usuario = usuarioRepository.findByEmail(tokenSubject);
                    
                    var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

                filterChain.doFilter(request, response);
    }

    private String getHeaderBearerToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");

        if(token != null){
            return token.replace("Bearer ", "");
        }
        
        return null;
    }

}
