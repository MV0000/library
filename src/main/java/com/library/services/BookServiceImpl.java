package com.library.services;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//@Component
//@Transactional
@Service
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
    public Book findbyId(int bookId) {
        return repository.findBookByBookId(bookId);
    }

    @Override
    @Transactional
    public void save(Book book) {

    }

    @Override
    @Transactional
    public void deleteById(int bookId) {

    }
}
