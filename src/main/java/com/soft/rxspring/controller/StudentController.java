package com.soft.rxspring.controller;

import com.soft.rxspring.model.Student;
import com.soft.rxspring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping
	Mono<Student> save(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping
	Flux<Student> findAll() {
		return studentService.getStudents();
	}

	@GetMapping("/{id}")
	Mono<Student> findById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}

}
