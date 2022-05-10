package com.booklibrary.demo.ui.uiactions;

import com.booklibrary.demo.mode.Book;
import com.booklibrary.demo.services.AddBookService;
import com.booklibrary.demo.ui.UIAction;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddBookUIAction implements UIAction {

  AddBookService bookService = new AddBookService();

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter title of the book");
        String bookTitle = scanner.nextLine();

        System.out.println("Enter author of the book");
        String bookAuthor = scanner.nextLine();

        System.out.println("Enter enter release date of the book");
        int releaseDate = scanner.nextInt();


        Book book = new Book(bookTitle,bookAuthor,releaseDate);
        bookService.execute(book);

    }

}
