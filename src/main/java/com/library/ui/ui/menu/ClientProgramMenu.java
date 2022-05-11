package com.library.ui.ui.menu;

import com.library.ui.UIAction;
import com.library.ui.ui.uiactions.ExitMenuUIAction;
import com.library.ui.ui.uiactions.FindBookBySearchCriteriaUIAction;
import com.library.ui.ui.uiactions.ShowAllBookUIAction;
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
    ClientProgramMenu(List<UIAction> uiActions){

        clientMenuNumberToUIActionMap = new HashMap<>();
        clientMenuNumberToUIActionMap.put(1, findUIAction(uiActions, ShowAllBookUIAction.class));
        clientMenuNumberToUIActionMap.put(2, findUIAction(uiActions, FindBookBySearchCriteriaUIAction.class));
        clientMenuNumberToUIActionMap.put(3, findUIAction(uiActions, ExitMenuUIAction.class));

    }


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
        System.out.println("1.  Show all books in the library");
        System.out.println("2.  Find book by author");
//        System.out.println("3.  Find book by title");
        System.out.println("3. Exit");


    }

    public int getUserChoice() {
        System.out.println("Select a menu number to continue");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) {
        clientMenuNumberToUIActionMap.get(selectedMenu).execute();
    }


}
