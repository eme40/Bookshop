package com.Eric.BookShopApplication.service;

import com.Eric.BookShopApplication.Response.ApiResponse;
import com.Eric.BookShopApplication.Response.UserSignupResponse;
import com.Eric.BookShopApplication.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
  ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(UserDto userDto);
}
