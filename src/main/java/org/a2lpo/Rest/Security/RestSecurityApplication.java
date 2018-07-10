package org.a2lpo.Rest.Security;

import org.a2lpo.Rest.Security.config.CustomUserDetais;
import org.a2lpo.Rest.Security.entites.Role;
import org.a2lpo.Rest.Security.entites.User;
import org.a2lpo.Rest.Security.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Arrays;

@SpringBootApplication
public class RestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSecurityApplication.class, args);
	}


	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder,
									  UserRepo repo) throws Exception {
		if (repo.count() == 0) {
			repo.save(new User("user","user",Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		}
		builder.userDetailsService(username -> new CustomUserDetais(repo.findByUsername(username)));
	}
}
