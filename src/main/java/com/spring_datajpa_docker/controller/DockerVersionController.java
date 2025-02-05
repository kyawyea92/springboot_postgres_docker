package com.spring_datajpa_docker.controller;

import com.spring_datajpa_docker.dto.DockerVersionDto;
import com.spring_datajpa_docker.model.DockerVersion;
import com.spring_datajpa_docker.service.DockerVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class DockerVersionController {

    @Autowired
    private DockerVersionService dockerVersionService;

    /**
     * Adds a new Docker version to the database.
     * 
     * This endpoint handles POST requests to create a new Docker version entry.
     * It takes a DockerVersionDto object as input and uses the dockerVersionService
     * to persist the new version information.
     *
     * @param dto The DockerVersionDto object containing the details of the new Docker version to be added.
     * @return ResponseEntity<DockerVersion> A ResponseEntity containing the newly created DockerVersion object
     *         if successful, or an appropriate error response if the operation fails.
     */
    @PostMapping("/version")
    public ResponseEntity<DockerVersion> addNewDockerVersion(@RequestBody DockerVersionDto dto) {
        return dockerVersionService.addDockerVersion(dto);
    }
}
