package com.example.LibraryManagementSpring;

import com.example.LibraryManagementSpring.Roles.Repositories.RoleRepository;
import com.example.LibraryManagementSpring.Users.Repositories.CustomUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {CustomUserRepository.class, RoleRepository.class})
public class LibraryManagementSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSpringApplication.class, args);
	}

}
