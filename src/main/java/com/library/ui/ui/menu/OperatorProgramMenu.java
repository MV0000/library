package com.library.ui.ui.menu;

import com.library.ui.UIAction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


@Component
public class OperatorProgramMenu implements UIAction {

    private Map<Integer, UIAction> operatorMenuNumberToUIActionMap;

    @Override
    public void execute() {

        while (true) {

            printProgramMenu();
            int menuNumber = getUserChoice();
            executeSelectedMenuItem(menuNumber);

        }

    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printProgramMenu() {

        System.out.println("Welcome to the Magnificent Emporium of Extravagant Collection of old and smelly books");
        System.out.println("Menu:");
        System.out.println("1.  Add a book to the library");
        System.out.println("2.  Delete book from the library");
        System.out.println("3.  Find book by title");
        System.out.println("4.  Find books by author");
        System.out.println("5.  Show all books in the library");
        System.out.println("6. Exit");


    }

    public int getUserChoice() {
        System.out.println("Select a menu number to continue");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) {
        operatorMenuNumberToUIActionMap.get(selectedMenu).execute();
    }


}
