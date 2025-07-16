package com.app.etude.etude.security;

import java.io.IOException;

import com.app.etude.etude.security.repository.TokenRepository;
import com.app.etude.etude.security.LogoutService;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.app.etude.etude.security.models.Token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter { //c'est une classe s'execute qu'une seule fois

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository; //verifier l'etat de token 

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }
        //pour recuperer le jwt de header 
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;   
        if(authHeader==null||!authHeader.startsWith("bearer")) {
        	filterChain.doFilter(request, response);
        	return;
        }
        jwt = authHeader.substring(7); //faire l'extraction de la chaine de caractaire numero 7
        userEmail = jwtService.extractUsername(jwt);
        //verfier l'utilisateur est authentifiable
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail); //telechargement de l'information de l'utilisateur authentifier 
            var isTokenValid = tokenRepository.findByToken(jwt) // Vérifier si le jeton est révoqué ou expiré
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);
            //validation le token pour l'utilisateur
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()//recuperer le role 
                );
                authToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken); //pour enregistrer l'authentification
            }
        }
        filterChain.doFilter(request, response);
        }
    }