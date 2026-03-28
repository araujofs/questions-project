package br.edu.ifpb.pweb2.eureka.auth;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/signin")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService service;
  private final SecurityContextRepository securityContextRepo;
  private final SecurityContextHolderStrategy securityContextHolderStrat = SecurityContextHolder
      .getContextHolderStrategy();

  @GetMapping
  public String getLoginPage(Model model) {
    model.addAttribute("authBody", new AuthRequest(""));

    return "signin";
  }

  @PostMapping
  public String postLoginForm(AuthRequest authBody, HttpServletRequest request, HttpServletResponse response,
      Model model) {
    try {
      var auth = this.service.authenticate(authBody);

      SecurityContext context = securityContextHolderStrat.createEmptyContext();
      context.setAuthentication(auth);
      securityContextHolderStrat.setContext(context);
      securityContextRepo.saveContext(context, request, response);

      return "home";
    } catch (Exception e) {
      model.addAttribute("errorMessage", e.getMessage());
      model.addAttribute("error", true);
    }

    return "signin";
  }
}
