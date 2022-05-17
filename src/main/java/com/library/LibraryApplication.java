package com.library;


import com.library.ui.ui.menu.ProgramMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.library")
public class LibraryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);

        ProgramMenu programMenu = context.getBean(ProgramMenu.class);

        while (true) {

            programMenu.printProgramMenu();
            int menuNumber = programMenu.getUserChoice();
            programMenu.executeSelectedMenuItem(menuNumber);

        }


        /*


        UI - menu
        Service -
        Repository
        DB



         */


    }
}


