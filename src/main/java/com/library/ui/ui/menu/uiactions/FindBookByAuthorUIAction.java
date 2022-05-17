package com.library.ui.ui.menu.uiactions;

import com.library.services.BookServiceImpl;
import com.library.ui.UIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindBookByAuthorUIAction implements UIAction {

    @Autowired
    BookServiceImpl bookService;

    @Override
    public void execute() {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter author of the book");
        String author = scanner.nextLine();


        System.out.println(bookService.findBooksByAuthor(author));
    }
}
