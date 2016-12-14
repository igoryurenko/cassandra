package com.iyurenko.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

/*
		UserByEmailRepository repository = applicationContext.getBean(UserByEmailRepository.class);

		// save a couple of users
		UserByEmail userByEmail = new UserByEmail();
		userByEmail.setEmail("fsdfsdfsdf");
		userByEmail.setLogin("1");

		repository.save(userByEmail);

		// fetch an individual user
		System.out.println("User found with email('fsdfsdfsdf'):");
		System.out.println("--------------------------------");
		System.out.println(repository.get("fsdfsdfsdf"));

*/
	}
}
