package com.reactspring.reactspring;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.reactspring.reactspring.user.User;
import com.reactspring.reactspring.user.UserService;


@SpringBootApplication
public class ReactSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactSpringApplication.class, args);
	}
	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
				User user = new User();
				user.setUsername("ferhan");
				user.setDisplayname("aydin");
				user.setPassword("P4ssword");
				userService.save(user);
		};
		
	}

}
