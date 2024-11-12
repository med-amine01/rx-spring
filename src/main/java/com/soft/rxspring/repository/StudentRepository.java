package com.soft.rxspring.repository;

import com.soft.rxspring.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

	Flux<Student> findAllByFirstnameIgnoreCase(String firstname);

}
