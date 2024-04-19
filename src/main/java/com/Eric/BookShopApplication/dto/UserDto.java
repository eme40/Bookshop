package com.Eric.BookShopApplication.dto;

import com.Eric.BookShopApplication.enums.Gender;
import com.Eric.BookShopApplication.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
  @Size(min = 2, max = 125, message = "firstname must be at least 2 character long ")
  @NotBlank(message = "Firstname must not be black")
  private String firstname;

  @Size(min = 2, max = 125, message = "lastname must be at least 2 character long ")
  @NotBlank(message = "Lastname must not be black")
  private String lastname;
  @Size(min = 2, max = 125)
  @NotBlank(message = "Email is required")
  @Email(message = "Email must be valid")
  private String email;

  @Size(min = 6, max = 65, message = "password must be at least 6 characters long ")
  @NotBlank(message = "password must not be black")
  private String password;

  @Size(min = 6, max = 65, message = " confirm password must be at least 6 characters long ")
  @NotBlank(message = "password must not be black")
  private String confirmPassword;

  private Role role;
  private Gender gender;

}
