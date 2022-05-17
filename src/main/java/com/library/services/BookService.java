package com.library.services;

import com.library.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public void saveBook(Book book);

    public Book findBookByBookId(int bookId);

    public void deleteById(int bookId);

    List<Book> findBooksByTitle( String bookTitle);

    List<Book> findBooksByAuthor(String bookAuthor);

}
