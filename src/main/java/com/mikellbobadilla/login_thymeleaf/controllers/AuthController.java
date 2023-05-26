package com.mikellbobadilla.login_thymeleaf.controllers;

import com.mikellbobadilla.login_thymeleaf.dto.AuthRequest;
import com.mikellbobadilla.login_thymeleaf.dto.RegisterRequest;
import com.mikellbobadilla.login_thymeleaf.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.AuthenticationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

  @PostMapping("/register")
  public String register(@ModelAttribute RegisterRequest registerRequest, RedirectAttributes redirectAttributes){
    String message = authService.register(registerRequest);
    redirectAttributes.addFlashAttribute("message", message);
    return "redirect:/login";
  }

  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public String errorRegister(RedirectAttributes redirectAttributes, SQLIntegrityConstraintViolationException exc){
    Logger.getLogger(AuthController.class.getName()).log(Level.WARNING, "App Message: " + exc.getMessage());
    redirectAttributes.addFlashAttribute("message","The user exists!");
    return "redirect:/register";
  }

}
