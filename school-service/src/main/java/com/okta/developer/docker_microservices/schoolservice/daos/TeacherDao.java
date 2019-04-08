package com.okta.developer.docker_microservices.schoolservice.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okta.developer.docker_microservices.schoolservice.entities.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Long> {

    List<Teacher> findByNameContaining(String name);
}