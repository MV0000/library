package com.booklibrary.demo.services;


import com.booklibrary.demo.mode.Book;
import com.booklibrary.demo.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class AddBookService {


    @Autowired
    private BookRepositoryImpl bookRepository;

    public void execute( Book book) {

        bookRepository.saveBook(book);

    }
}
