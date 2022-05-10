package com.booklibrary.demo.repository;

import com.booklibrary.demo.mode.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Book> books = new ArrayList<Book>();

    @Override
    public void saveBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books.stream().toList();
    }

    @Override
    public List<Book> findBooksByTitle(String bookTitle) {
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String bookAuthor) {
        return null;
    }

}
