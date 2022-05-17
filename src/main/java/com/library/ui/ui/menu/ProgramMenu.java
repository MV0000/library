package com.library.ui.ui.menu;

import com.library.ui.UIAction;
import com.library.ui.ui.menu.uiactions.ExitMenuUIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ProgramMenu {

    private Map<Integer, UIAction> programMenuNumberToUIActionMap;

    @Autowired
    ProgramMenu(List<UIAction> uiActions) {

        programMenuNumberToUIActionMap = new HashMap<>();
        programMenuNumberToUIActionMap.put(1, findUIAction(uiActions, ClientProgramMenu.class));
        programMenuNumberToUIActionMap.put(2, findUIAction(uiActions, OperatorProgramMenu.class));
        programMenuNumberToUIActionMap.put(3, findUIAction(uiActions, ExitMenuUIAction.class));

    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printProgramMenu() {

        System.out.println("Welcome please choose your account type");
        System.out.println("1.  Client");
        System.out.println("2.  Operator");
        System.out.println("3.  Exit");
    }

    public int getUserChoice() {
        System.out.println("Select a menu number to continue");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) {
        programMenuNumberToUIActionMap.get(selectedMenu).execute();
    }
}
