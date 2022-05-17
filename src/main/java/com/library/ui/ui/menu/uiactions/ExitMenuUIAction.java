package com.library.ui.ui.menu.uiactions;

import com.library.ui.UIAction;
import org.springframework.stereotype.Component;

@Component
public class ExitMenuUIAction implements UIAction {


    @Override
    public void execute() {
        System.out.println("See you later, by!");
        System.exit(0);
    }
}
