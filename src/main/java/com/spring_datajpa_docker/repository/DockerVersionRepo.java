package com.spring_datajpa_docker.repository;

import com.spring_datajpa_docker.model.DockerVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockerVersionRepo extends JpaRepository<DockerVersion,Long> {}
