package com.mikellbobadilla.login_thymeleaf.controllers;

import com.mikellbobadilla.login_thymeleaf.entity.User;
import com.mikellbobadilla.login_thymeleaf.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

  private final UserRepository userRepository;

  public IndexController(UserRepository userRepository){
    this.userRepository = userRepository;
  }


  @GetMapping("/")
  public String usersPage(Model model){
    List<User> users = userRepository.findAll();
    model.addAttribute("users", users);
    return "index";
  }

//  Este controlador ya fue removido

}
