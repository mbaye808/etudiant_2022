package org.sid.secservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Configuration
public class SecServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecServiceApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
/*
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args->{
		{
			
			accountService.addNewRole(new AppRole("USER"));
			accountService.addNewRole(new AppRole("ADMIN"));
			accountService.addNewRole(new AppRole("CUSTOMER_MANAGER"));
			accountService.addNewRole(new AppRole("PRODUCT_MANAGER"));
			accountService.addNewRole(new AppRole("BILSS_MANAGER"));
			
			
			accountService.addNewUser(new AppUser("user1", "1234", "franc", "diouf", null, "202024561", "diouf@gmail.com", new ArrayList<>()));
			accountService.addNewUser(new AppUser("admin", "1234", "azur", "diouf", null, "202024A09", "diop@gmail.com", new ArrayList<>()));
			accountService.addNewUser(new AppUser("user2", "1234", "codou", "diaw", null, "20202546", "diaw@gmail.com", new ArrayList<>()));
			accountService.addNewUser(new AppUser("user3", "1234", "plot", "ndiaye", null, "202209345", "nd@gmail.com", new ArrayList<>()));
			accountService.addNewUser(new AppUser("user4", "1234", "sophie", "diokh", null, "20200P987", "baba@gmail.com", new ArrayList<>()));
			
			accountService.addRoleToUser("user1","USER");
			accountService.addRoleToUser("admin","USER");
			accountService.addRoleToUser("admin","ADMIN");
			accountService.addRoleToUser("user2","USER");
			accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
			accountService.addRoleToUser("user3","USER");
			accountService.addRoleToUser("user3","PRODUCT_MANAGER");
			accountService.addRoleToUser("user4","USER");
			accountService.addRoleToUser("user4","BILLS_MANAGER");
		}}; 
}*/
	}
