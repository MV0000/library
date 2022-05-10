package com.booklibrary.demo.repository;


import com.booklibrary.demo.mode.Book;

import java.util.List;

public interface BookRepository {

    void saveBook(Book book);

    List<Book> getAllBooks();

    List<Book> findBooksByTitle( String bookTitle);

    List<Book> findBookByAuthor(String bookAuthor);
}
