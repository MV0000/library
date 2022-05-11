package com.library.services;

import com.library.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findbyId(int bookId);

    public void save(Book book);

    public void deleteById(int bookId);
}
