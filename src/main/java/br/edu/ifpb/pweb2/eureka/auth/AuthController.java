package br.edu.ifpb.pweb2.eureka.auth;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService service;
  private final SecurityContextRepository securityContextRepo;
  private final SecurityContextHolderStrategy securityContextHolderStrat = SecurityContextHolder
      .getContextHolderStrategy();

  @GetMapping("/login")
  public String getLoginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String postLoginForm(AuthRequest authBody, HttpServletRequest request, HttpServletResponse response) {
    var auth = this.service.authenticate(authBody);

    SecurityContext context = securityContextHolderStrat.createEmptyContext();
    context.setAuthentication(auth);
    securityContextHolderStrat.setContext(context);
    securityContextRepo.saveContext(context, request, response);

    CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();

    // use the details to get an id or smth

    return "login";
  }

}
