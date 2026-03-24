package br.edu.ifpb.pweb2.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) {
    http.authorizeHttpRequests(
        auth -> auth
            .requestMatchers("/signin", "/signup").anonymous()
            .anyRequest().authenticated())
        .formLogin(form -> form.disable())
        .logout(logout -> logout.logoutUrl("/signout"));

    return http.build();
  }

  @Bean
  AuthenticationManager authenticationManager(UserDetailsService detailsService) {
    var authProvider = new DaoAuthenticationProvider(detailsService);

    return new ProviderManager(authProvider);
  }
}
