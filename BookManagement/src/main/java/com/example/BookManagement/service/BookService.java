package com.example.BookManagement.service;

import com.example.BookManagement.model.Book;
import com.example.BookManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        bookDetails.setId(id); // Đảm bảo id không thay đổi
        return bookRepository.save(bookDetails);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}