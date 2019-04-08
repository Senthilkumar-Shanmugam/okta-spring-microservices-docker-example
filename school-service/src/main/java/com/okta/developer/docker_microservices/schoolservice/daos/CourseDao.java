package com.okta.developer.docker_microservices.schoolservice.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okta.developer.docker_microservices.schoolservice.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
}