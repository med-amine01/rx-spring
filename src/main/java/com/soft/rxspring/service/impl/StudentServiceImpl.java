package com.soft.rxspring.service.impl;

import com.soft.rxspring.model.Student;
import com.soft.rxspring.repository.StudentRepository;
import com.soft.rxspring.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	@Override
	public Flux<Student> getStudents() {
		return studentRepository.findAll().delayElements(Duration.ofSeconds(1));
	}

	@Override
	public Mono<Student> getStudentById(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public Mono<Student> createStudent(Student student) {
		return studentRepository.save(student);
	}

}
