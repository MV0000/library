package com.library.ui.ui.uiactions;

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
