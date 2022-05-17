package com.library.ui.ui.menu.uiactions;

import com.library.services.BookServiceImpl;
import com.library.ui.UIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindBookByTitleUIAction implements UIAction {

    @Autowired
    BookServiceImpl bookService;

    @Override
    public void execute() {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter title of the book");
        String title = scanner.nextLine();


        System.out.println(bookService.findBooksByTitle(title));
    }
}
