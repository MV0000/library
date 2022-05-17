package com.library.ui.ui.menu.uiactions;

import com.library.services.BookServiceImpl;
import com.library.ui.UIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindBookByIdUIAction implements UIAction {

    @Autowired
    BookServiceImpl bookService;

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Id of the book");
        int bookId = scanner.nextInt();


        System.out.println(bookService.findBookByBookId(bookId));
    }
}
