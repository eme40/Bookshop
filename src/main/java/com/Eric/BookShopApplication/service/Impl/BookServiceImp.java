package com.Eric.BookShopApplication.service.Impl;

import com.Eric.BookShopApplication.dto.BookDto;
import com.Eric.BookShopApplication.exception.BookNotFoundException;
import com.Eric.BookShopApplication.exception.UserNotFoundException;
import com.Eric.BookShopApplication.model.Book;
import com.Eric.BookShopApplication.model.User;
import com.Eric.BookShopApplication.respository.BookRepository;
import com.Eric.BookShopApplication.respository.UserRepository;
import com.Eric.BookShopApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {
  private final UserRepository userRepository;
  private final BookRepository bookRepository;
  @Override
  public BookDto createBook(Long id, BookDto bookDto) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("user does not exists!"));

    Book book = Book.builder()
            .title(bookDto.getTitle())
            .author(bookDto.getAuthor())
            .pages(bookDto.getPages())
            .user(user)
            .build();

    bookRepository.save(book);
    return bookDto;
  }

  @Override
  public BookDto getBookById(Long id) {
    Book book = bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("Book Not Found!"));
    BookDto bookDto = new BookDto();
    BeanUtils.copyProperties(book, bookDto);

    return bookDto;
  }
}
