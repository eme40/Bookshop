package com.Eric.BookShopApplication.respository;

import com.Eric.BookShopApplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
 // List<Book> findUserId(Long userId);
}
