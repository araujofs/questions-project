package br.edu.ifpb.pweb2.eureka.auth;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

  private final boolean isAdmin;
  private final String name;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (this.isAdmin) {
      return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    return List.of(new SimpleGrantedAuthority("ROLE_PARTICIPANT"));
  }

  @Override
  public @Nullable String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return this.name;
  }
}
