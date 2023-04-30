package com.mikellbobadilla.login_thymeleaf.services;

import com.mikellbobadilla.login_thymeleaf.dto.RegisterRequest;
import com.mikellbobadilla.login_thymeleaf.entity.RoleUser;
import com.mikellbobadilla.login_thymeleaf.entity.User;
import com.mikellbobadilla.login_thymeleaf.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final UserRepository userRepository;

  public final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }


  public String register(RegisterRequest request){
    User user = new User(
      request.getUsername(),
      request.getName(),
      passwordEncoder.encode(request.getPassword()),
      RoleUser.USER
    );

    User u = userRepository.save(user);

    System.out.println(u);

    return "Register Complete!";
  }

}
