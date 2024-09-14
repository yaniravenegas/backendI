package com.example.ClinicaOdontologicaC3.Security;

import com.example.ClinicaOdontologicaC3.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Habilitar @PreAuthorize
public class WebSecurityConfig {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usuarioService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/h2-console/**").permitAll()  // Permitir acceso a la consola H2 sin autenticación
                        .requestMatchers("/odontologo/**", "/paciente/**").hasRole("ADMIN")  // Restricción para admin
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .logout(withDefaults())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())); // Permitir iframes de la misma fuente

        return http.build();
    }
}
