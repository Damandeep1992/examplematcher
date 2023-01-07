package com.greatlearning.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import com.greatlearning.library.config.SwaggerConfig;
import com.greatlearning.library.entity.Library;
import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.serviceImpl.LibraryReadServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {
	
	@Autowired
	LibraryReadServiceImpl libraryReadServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("hello");
		System.out.println("damien");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Fetch all libraries -> {}",libraryReadServiceImpl.getAllLibrary());
		log.info("Fetch all libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
	}
}
 