package com.okta.developer.docker_microservices.schoolservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okta.developer.docker_microservices.schoolservice.dtos.TeachingClassDto;
import com.okta.developer.docker_microservices.schoolservice.services.TeachingClassService;

@RestController("/class")
public class TeachingClassController {


    private final TeachingClassService teachingClassService;

    public TeachingClassController(TeachingClassService teachingClassService) {
        this.teachingClassService = teachingClassService;
    }

    @GetMapping
    public List<TeachingClassDto> listClasses(){
        return teachingClassService.listClasses();
    }

}