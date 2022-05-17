package com.library.services;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BookServiceImpl implements BookService{

    private BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }



    @Override
    @Transactional
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Book findBookByBookId(int bookId) {
        return repository.findBookByBookId(bookId);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {

        repository.saveBook(book);

    }

    @Override
    @Transactional
    public void deleteById(int bookId) {

        repository.deleteById(bookId);

    }

    @Override
    public List<Book> findBooksByTitle(String bookTitle) {
        return repository.findBooksByTitle(bookTitle);
    }

    @Override
    public List<Book> findBooksByAuthor(String bookAuthor) {
        return repository.findBooksByAuthor(bookAuthor);
    }
}
