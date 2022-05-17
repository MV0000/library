package com.library.ui.ui.menu;

import com.library.ui.UIAction;
import com.library.ui.ui.menu.uiactions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


@Component
public class OperatorProgramMenu implements UIAction {

    private Map<Integer, UIAction> operatorMenuNumberToUIActionMap;

    @Autowired
    OperatorProgramMenu(List<UIAction> uiActions){

        operatorMenuNumberToUIActionMap = new HashMap<>();
        operatorMenuNumberToUIActionMap.put(1, operatorFindUIAction(uiActions, ShowAllBookUIAction.class));
        operatorMenuNumberToUIActionMap.put(2, operatorFindUIAction(uiActions, FindBookByIdUIAction.class));
        operatorMenuNumberToUIActionMap.put(3, operatorFindUIAction(uiActions, FindBookByTitleUIAction.class));
        operatorMenuNumberToUIActionMap.put(4, operatorFindUIAction(uiActions, FindBookByAuthorUIAction.class));
        operatorMenuNumberToUIActionMap.put(5, operatorFindUIAction(uiActions, SaveBookUIAction.class));
        operatorMenuNumberToUIActionMap.put(6, operatorFindUIAction(uiActions, DeleteBookUIAction.class));
        operatorMenuNumberToUIActionMap.put(7, operatorFindUIAction(uiActions, ExitMenuUIAction.class));

    }

    @Override
    public void execute() {

        while (true) {

            printOperatorProgramMenu();
            int menuNumber = getOperatorUserChoice();
            executeOperatorSelectedMenuItem(menuNumber);

        }

    }

    private UIAction operatorFindUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printOperatorProgramMenu() {

        System.out.println("Welcome to the Magnificent Emporium of Extravagant Collection of old and smelly books");
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1.  Show all books in the library");
        System.out.println("2.  Find book by Id");
        System.out.println("3.  Find book by title");
        System.out.println("4.  Find book by author");
        System.out.println("5.  Save book to library");
        System.out.println("6.  Delete book from library");
        System.out.println("5. Exit");


    }

    public int getOperatorUserChoice() {
        System.out.println("Select a menu number to continue");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeOperatorSelectedMenuItem(int selectedMenu) {
        operatorMenuNumberToUIActionMap.get(selectedMenu).execute();
    }


}
