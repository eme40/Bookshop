package com.Eric.BookShopApplication.dto;

import com.Eric.BookShopApplication.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BookDto {
  @NotBlank(message = "title must not be black")
  private String title;
  @NotBlank(message = "author must not be black")
  private String author;
  @NotBlank(message = "pages must not be black")
  private int pages;
  private BookStatus bookStatus;
  
}
