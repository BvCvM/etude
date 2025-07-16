package com.app.etude.etude.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import lombok.RequiredArgsConstructor;

@Configuration // Indique que cette classe fournit une configuration Spring
@EnableWebSecurity // Active la sécurité Web via Spring Security
@EnableMethodSecurity // Active la sécurité au niveau des méthodes (ex: @PreAuthorize)
@RequiredArgsConstructor // Génère automatiquement un constructeur avec les champs "final" (injection des dépendances)
public class SecurityConfig {

    // URLs accessibles sans authentification (liste blanche)
    private static final String[] WHITE_LIST_URL = {
        "/api/v1/verfy/**",
        "/api/v1/users/**",
        "/api/v1/auth/**",
        "/v2/api-docs",
        "/v3/api-docs",
        "/v3/api-docs/**",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/webjars/**",
        "/api/**",
        "/api/v1/Role/**"
    };

    private final JwtAuthenticationFilter jwtAuthFilter; // Filtre personnalisé pour extraire et valider le JWT
    private final AuthenticationProvider authenticationProvider; // Fournisseur d'authentification (ex: DaoAuthenticationProvider)
    private final LogoutHandler logoutHandler; // Handler personnalisé pour gérer la déconnexion (invalidation de token, etc.)

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Désactivation de la protection CSRF (car on utilise des JWT, pas de session côté serveur)
            .csrf(AbstractHttpConfigurer::disable)

            // Configuration des autorisations pour les requêtes HTTP
            .authorizeHttpRequests(req -> req
                .requestMatchers(WHITE_LIST_URL) // Autoriser sans authentification les URLs listées
                .permitAll()
                .anyRequest() // Toute autre requête
                .authenticated() // doit être authentifiée
            )

            // Gestion de session stateless (JWT, pas de session côté serveur)
            .sessionManagement(session -> session
                .sessionCreationPolicy(STATELESS)
            )

            // Fournisseur d'authentification utilisé par Spring Security
            .authenticationProvider(authenticationProvider)

            // Ajout du filtre JWT AVANT le filtre d’authentification UsernamePasswordAuthenticationFilter
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)

            // Configuration de la déconnexion personnalisée
            .logout(logout -> logout
                .logoutUrl("/api/v1/auth/logout") // URL de déconnexion
                .addLogoutHandler(logoutHandler) // Handler exécuté lors de la déconnexion
                .logoutSuccessHandler((request, response, authentication) ->
                    SecurityContextHolder.clearContext() // Nettoyage du contexte de sécurité après déconnexion
                )
            );

        return http.build(); // Construction de la chaîne de filtres de sécurité
    }
}
