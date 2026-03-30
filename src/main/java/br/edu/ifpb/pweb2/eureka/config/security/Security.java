package br.edu.ifpb.pweb2.eureka.config.security;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
public class Security {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) {
    http.authorizeHttpRequests(
        auth -> auth
            .requestMatchers("/error", "/css/**", "/js/**", "/images/**").permitAll()
            .requestMatchers("/signin", "/signup").anonymous()
            .anyRequest().authenticated())
        .formLogin(form -> form
            .loginPage("/signin")
            .defaultSuccessUrl("/home")
            .permitAll())
        .logout(logout -> logout.logoutUrl("/signout"))
        .csrf(csrf -> csrf.disable());

    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new PasswordEncoder() {
      @Override
      public @Nullable String encode(@Nullable CharSequence arg0) {
        return "";
      }

      @Override
      public boolean matches(@Nullable CharSequence arg0, @Nullable String arg1) {
        return true;
      }
    };
  }

  @Bean
  AuthenticationManager authenticationManager(UserDetailsService detailsService, PasswordEncoder encoder) {
    var authProvider = new DaoAuthenticationProvider(detailsService);
    authProvider.setPasswordEncoder(encoder);

    return new ProviderManager(authProvider);
  }

  @Bean
  SecurityContextRepository securityContextRepository() {
    return new HttpSessionSecurityContextRepository();
  }
}
