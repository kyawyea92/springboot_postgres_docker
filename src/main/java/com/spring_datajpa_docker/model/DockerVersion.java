package com.spring_datajpa_docker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

/**
 * This class represents a Docker version entity. It is used to store information about different Docker versions.
 *
 * @author Tabnine team
 */
@Entity
public class DockerVersion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private String name;

    // Getters and Setters

    /**
     * Returns the unique identifier of the Docker version.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the Docker version.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the version number of the Docker.
     *
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the version number of the Docker.
     *
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Returns the name of the Docker version.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Docker version.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
