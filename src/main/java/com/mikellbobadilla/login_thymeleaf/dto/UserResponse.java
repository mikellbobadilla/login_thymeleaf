package com.mikellbobadilla.login_thymeleaf.dto;

import com.mikellbobadilla.login_thymeleaf.entity.RoleUser;

public record UserResponse(String username, String lastName, RoleUser role) {
}
