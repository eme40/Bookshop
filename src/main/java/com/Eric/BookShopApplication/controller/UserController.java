package com.Eric.BookShopApplication.controller;

import com.Eric.BookShopApplication.Response.ApiResponse;
import com.Eric.BookShopApplication.Response.UserSignupResponse;
import com.Eric.BookShopApplication.dto.UserDto;
import com.Eric.BookShopApplication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(@Valid @RequestBody UserDto userDto){
    return userService.registerUser(userDto);
  }
}
