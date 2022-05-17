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
public class ClientProgramMenu implements UIAction {

    private Map<Integer, UIAction> clientMenuNumberToUIActionMap;

    @Autowired
    ClientProgramMenu(List<UIAction> uiActions) {

        clientMenuNumberToUIActionMap = new HashMap<>();
        clientMenuNumberToUIActionMap.put(1, clientFindUIAction(uiActions, ShowAllBookUIAction.class));
        clientMenuNumberToUIActionMap.put(2, clientFindUIAction(uiActions, FindBookByIdUIAction.class));
        clientMenuNumberToUIActionMap.put(3, clientFindUIAction(uiActions, FindBookByTitleUIAction.class));
        clientMenuNumberToUIActionMap.put(4, clientFindUIAction(uiActions, FindBookByAuthorUIAction.class));
        clientMenuNumberToUIActionMap.put(5, clientFindUIAction(uiActions, SaveBookUIAction.class));
        clientMenuNumberToUIActionMap.put(6, clientFindUIAction(uiActions, ExitMenuUIAction.class));

    }

    public ClientProgramMenu(Map<Integer, UIAction> clientMenuNumberToUIActionMap) {
        this.clientMenuNumberToUIActionMap = clientMenuNumberToUIActionMap;
    }


    public void executeSelectedMenuItem(int selectedMenu) {
        clientMenuNumberToUIActionMap.get(selectedMenu).execute();
    }

    @Override
    public void execute() {

        while (true) {
            printProgramMenu();
            int menuNumber = getUserChoice();
            executeSelectedMenuItem(menuNumber);
        }
    }

    private UIAction clientFindUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printProgramMenu() {

        System.out.println("Welcome to the Magnificent Emporium of Extravagant Collection of old and smelly books");
        System.out.println("Menu:");
        System.out.println("1.  Show all books in the library");
        System.out.println("2.  Find book by Id");
        System.out.println("3.  Find book by title");
        System.out.println("4.  Find book by author");
        System.out.println("5.  Save book to library");
        System.out.println("6. Exit");


    }

    public int getUserChoice() {
        System.out.println("Select a menu number to continue");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }


}
