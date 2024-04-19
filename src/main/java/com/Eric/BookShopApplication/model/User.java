package com.Eric.BookShopApplication.model;

import com.Eric.BookShopApplication.enums.Gender;
import com.Eric.BookShopApplication.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tbl")
public class User extends BaseClass{
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Book> books;


}
