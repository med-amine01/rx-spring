package com.soft.rxspring.service;

import com.soft.rxspring.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

	Flux<Student> getStudents();

	Mono<Student> getStudentById(Integer id);

	Mono<Student> createStudent(Student student);

}
