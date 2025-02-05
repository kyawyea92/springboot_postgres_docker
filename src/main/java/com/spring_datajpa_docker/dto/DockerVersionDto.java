package com.spring_datajpa_docker.dto;

public class DockerVersionDto {
    private int version;
    private String name;
    // Getters and Setters

    /**
     * Retrieves the version of the Docker.
     *
     * @return the version of the Docker as an integer.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the version of the Docker.
     *
     * @param version the version to set, represented as an integer.
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Retrieves the name of the Docker.
     *
     * @return the name of the Docker as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Docker.
     *
     * @param name the name to set, represented as a String.
     */
    public void setName(String name) {
        this.name = name;
    }
}
