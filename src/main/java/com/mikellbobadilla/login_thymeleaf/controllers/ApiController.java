package com.mikellbobadilla.login_thymeleaf.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/say")
public class ApiController {
  
  @GetMapping("/greetings")
  public String sayHello(){
    return "Hoa que tal";
  }
}
