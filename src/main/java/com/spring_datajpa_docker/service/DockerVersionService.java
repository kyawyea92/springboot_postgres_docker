package com.spring_datajpa_docker.service;

import com.spring_datajpa_docker.dto.DockerVersionDto;
import com.spring_datajpa_docker.model.DockerVersion;
import com.spring_datajpa_docker.repository.DockerVersionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DockerVersionService {

    @Autowired
    private DockerVersionRepo dockerVersionRepo;

    /**
     * Adds a new Docker version to the database.
     *
     * @param dto The DockerVersionDto containing the version information to be added.
     * @return A ResponseEntity containing the saved DockerVersion entity if successful.
     */
    public ResponseEntity<DockerVersion> addDockerVersion(DockerVersionDto dto){
        DockerVersion entity = this.dockerVersionDtoToEntity(dto);
        entity = dockerVersionRepo.save(entity);
        return ResponseEntity.ok(entity);
    }

    /**
     * Retrieves a Docker version by its ID.
     *
     * @param id The ID of the Docker version to retrieve.
     * @return The DockerVersion entity if found, or null if not found.
     */
    public DockerVersion getDockerVersionById(Long id){
        return dockerVersionRepo.findById(id).orElse(null);
    }

    /**
     * Converts a DockerVersionDto to a DockerVersion entity.
     *
     * @param dto The DockerVersionDto to be converted.
     * @return A new DockerVersion entity with properties set from the DTO.
     */
    public DockerVersion dockerVersionDtoToEntity(DockerVersionDto dto) {
        DockerVersion entity = new DockerVersion();
        entity.setVersion(dto.getVersion());
        entity.setName(dto.getName());
        return entity;
    }
}
