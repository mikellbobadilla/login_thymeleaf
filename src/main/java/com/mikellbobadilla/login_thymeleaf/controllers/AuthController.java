package com.mikellbobadilla.login_thymeleaf.controllers;

import com.mikellbobadilla.login_thymeleaf.dto.AuthRequest;
import com.mikellbobadilla.login_thymeleaf.dto.RegisterRequest;
import com.mikellbobadilla.login_thymeleaf.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @GetMapping("/login")
  public String loginPage(Model model){
    AuthRequest authRequest = new AuthRequest();
    model.addAttribute("authRequest", authRequest);
    return "login";
  }

  @GetMapping("/register")
  public String registerPage(Model model){
    RegisterRequest registerRequest = new RegisterRequest();
    model.addAttribute("registerRequest", registerRequest);
    return "register";
  }

  @PostMapping("/login")
  public String register(@ModelAttribute RegisterRequest registerRequest){
    authService.register(registerRequest);
    return "redirect:/login";
  }
}
