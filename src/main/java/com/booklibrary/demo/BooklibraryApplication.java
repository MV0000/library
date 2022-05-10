package com.booklibrary.demo;

import com.booklibrary.demo.ui.ProgramMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BooklibraryApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BooklibraryApplication.class, args);

		ConfigurableApplicationContext applicationContext = SpringApplication.run(BooklibraryApplication.class);

		ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
		while (true) {
			programMenu.printProgramMenu();
			int menuNumber = programMenu.getUserChoice();
			programMenu.executeSelectedMenuItem(menuNumber);
		}
	}



}
