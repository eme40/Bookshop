package com.Eric.BookShopApplication.service.Impl;

import com.Eric.BookShopApplication.Response.ApiResponse;
import com.Eric.BookShopApplication.Response.UserSignupResponse;
import com.Eric.BookShopApplication.dto.UserDto;
import com.Eric.BookShopApplication.enums.Gender;
import com.Eric.BookShopApplication.enums.Role;
import com.Eric.BookShopApplication.exception.EmailAlreadyExistsException;
import com.Eric.BookShopApplication.model.User;
import com.Eric.BookShopApplication.respository.UserRepository;
import com.Eric.BookShopApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;



  @Override
  public ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(UserDto userDto) {
    boolean userExists = userRepository.findUserByEmail(userDto.getEmail()).isPresent();
    if (userExists){
      throw new EmailAlreadyExistsException("Email already exist. kindly log into your account");
    }
    User newUser = User.builder()
            .firstname(userDto.getFirstname())
            .lastname(userDto.getLastname())
            .email(userDto.getEmail())
            .role(Role.USER)
            .password(userDto.getPassword())
            .gender(Gender.valueOf(String.valueOf(userDto.getGender())))
            .build();

    userRepository.save(newUser);

    UserSignupResponse userSignupResponse = UserSignupResponse.builder()
            .firstname(userDto.getFirstname())
            .lastname(userDto.getLastname())
            .email(userDto.getEmail())
            .build();

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ApiResponse<>("Account created succesfully", userSignupResponse));
  }
}
