package com.library.ui.ui.menu.uiactions;

import com.library.services.BookServiceImpl;
import com.library.ui.UIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAllBookUIAction implements UIAction {


    @Autowired
    BookServiceImpl bookService;

    @Override
    public void execute() {

        bookService.findAll().forEach(System.out::println);

    }
}
