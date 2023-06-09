package org.example.service;

import jakarta.jws.WebService;
import org.example.entity.Book;

import java.util.List;

@WebService
public interface LibraryService {
    List<Book> getAllBooks();
    List<Book> findByAuthor(String author);
    List<Book> findByName(String name);
}
