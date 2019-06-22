package com.ss.storyboxcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.ss.storyboxcrud.model.Journal;


@SpringBootApplication
@EnableResourceServer
public class StoryboxCrudApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(StoryboxCrudApplication.class, args);
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// TODO Auto-generated method stub
		config.exposeIdsFor(Journal.class);
	}

}
