package com.okta.developer.docker_microservices.schoolservice.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okta.developer.docker_microservices.schoolservice.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);

    List<Student> findByAgeBetween(short smallerAge, short biggerAge);

}