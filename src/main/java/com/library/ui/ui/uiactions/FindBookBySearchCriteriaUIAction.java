package com.library.ui.ui.uiactions;

import com.library.services.BookServiceImpl;
import com.library.ui.UIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindBookBySearchCriteriaUIAction implements UIAction {

    @Autowired
    BookServiceImpl bookService;

    @Override
    public void execute() {

    }
}
