package com.wellsfargo.app;

import com.wellsfargo.app.validator.FileSanityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LzFileSanityCheckerApplication implements CommandLineRunner {

	@Autowired
	private FileSanityValidator fileSanityValidator;
	public static void main(String[] args) {
		SpringApplication.run(LzFileSanityCheckerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileSanityValidator.validateAll();
	}
}
