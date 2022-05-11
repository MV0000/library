package com.library.ui.ui.uiactions;

import com.library.entity.Book;
import com.library.services.BookServiceImpl;
import com.library.ui.UIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SaveBookUIAction implements UIAction {

    @Autowired
    BookServiceImpl bookService;

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter title of the book");
        String bookTitle = scanner.nextLine();

        System.out.println("Enter author of the book");
        String bookAuthor = scanner.nextLine();

        System.out.println("Enter enter release date of the book");
        int releaseDate = scanner.nextInt();


        Book book = new Book(bookTitle, bookAuthor, releaseDate);
        bookService.save(book);

    }

}
