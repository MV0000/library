package com.library.repository;



import com.library.entity.Book;

import java.util.List;

public interface BookRepository {

    void saveBook(Book bookToSave);

    List<Book> findAll();

    List<Book> findBooksByTitle( String bookTitle);

    List<Book> findBookByAuthor(String bookAuthor);

    Book findBookByBookId(int bookId);
}
