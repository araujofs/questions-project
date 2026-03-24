package br.edu.ifpb.pweb2.eureka.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ifpb.pweb2.eureka.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository repo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var user = repo.findByName(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com nome: \"" + username + "\"!"));

    return new CustomUserDetails(
        user.isAdmin(),
        user.getName());
  }
}
