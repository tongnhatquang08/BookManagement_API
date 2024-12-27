package com.example.BookManagement.repository;

import com.example.BookManagement.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private long currentId = 1;

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(currentId++);
            books.add(book);
        } else {
            // Cập nhật sách
            int index = books.indexOf(findById(book.getId()).orElse(null));
            if (index >= 0) {
                books.set(index, book);
            }
        }
        return book;
    }

    public void deleteById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}