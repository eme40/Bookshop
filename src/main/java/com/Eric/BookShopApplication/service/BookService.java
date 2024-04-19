package com.Eric.BookShopApplication.service;

import com.Eric.BookShopApplication.dto.BookDto;

public interface BookService {
  BookDto createBook(Long id, BookDto bookDto);
  BookDto getBookById(Long id);

}
