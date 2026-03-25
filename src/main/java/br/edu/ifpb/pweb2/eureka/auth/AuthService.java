package br.edu.ifpb.pweb2.eureka.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthenticationManager authManager;

  public Authentication authenticate(AuthRequest authBody) {
    Authentication auth = UsernamePasswordAuthenticationToken.unauthenticated(authBody.name(), "");

    // here it can throw an error
    // TODO: implement error page
    auth = this.authManager.authenticate(auth);

    return auth;
  }

  public AuthStatus isAuthenticated(Authentication auth) {
    if (auth == null || !(auth.getPrincipal() instanceof CustomUserDetails))
      return new AuthStatus(false, null);

    return new AuthStatus(true, ((CustomUserDetails) auth.getPrincipal()).getUsername());
  }
}
