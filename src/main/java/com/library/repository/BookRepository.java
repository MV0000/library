package com.library.repository;



import com.library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findAll();

    void saveBook(Book bookToSave);

    Book findBookByBookId(int bookId);

    public void deleteById(int bookId);

    List<Book> findBooksByTitle( String bookTitle);

    List<Book> findBooksByAuthor(String bookAuthor);


}
