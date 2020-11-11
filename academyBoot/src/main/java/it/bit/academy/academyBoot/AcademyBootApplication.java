package it.bit.academy.academyBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.bit.academy.academyBoot.controller.StudentController;
import it.bit.academy.academyBoot.dto.StudentDto;
import it.bit.academy.academyBoot.model.Student;

@SpringBootApplication
public class AcademyBootApplication implements CommandLineRunner {

	@Autowired
	StudentController controller;

	public static void main(String[] args) {
		SpringApplication.run(AcademyBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//controller.findAll().stream().map(StudentDto::getNome).forEach(System.out::println);
		//controller.findByNameLike("rio").stream().map(StudentDto::getNome).forEach(System.out::println);
	}

}
