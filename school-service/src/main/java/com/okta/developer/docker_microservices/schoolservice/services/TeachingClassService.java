package com.okta.developer.docker_microservices.schoolservice.services;

import java.util.List;

import com.okta.developer.docker_microservices.schoolservice.dtos.TeachingClassDto;

public interface TeachingClassService {
    List<TeachingClassDto> listClasses();
}
