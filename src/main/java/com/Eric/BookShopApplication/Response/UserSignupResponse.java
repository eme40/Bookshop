package com.Eric.BookShopApplication.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignupResponse {
  private String firstname;
  private String lastname;
  private String email;
}
