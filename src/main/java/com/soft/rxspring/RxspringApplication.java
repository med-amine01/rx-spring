package com.soft.rxspring;

import com.soft.rxspring.model.Student;
import com.soft.rxspring.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static java.lang.String.format;

@SpringBootApplication
public class RxspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxspringApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentService studentService) {
		return args -> {
			for (int i = 0; i <= 100; i++) {
				studentService
					.createStudent(Student.builder()
						.firstname(format("mad_%s", i))
						.lastname(format("chicken_%s", i))
						.age(i)
						.build())
					.subscribe();
			}
		};
	}

}
