package com.security.inMemory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
public class InMemoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InMemoryApplication.class, args);
	}

	@Bean
	UserDetailsManager memory(){
		return new InMemoryUserDetailsManager();
	}

	@Bean
	InitializingBean initializer(UserDetailsManager manager){
		return () -> {
			UserDetails one = User.withDefaultPasswordEncoder().username("nitin").password("password").roles("USER").build();
			manager.createUser(one);

			UserDetails two = User.withDefaultPasswordEncoder().username("kumar").password("password").roles("USER").build();
			manager.createUser(two);
		};
	}


}
