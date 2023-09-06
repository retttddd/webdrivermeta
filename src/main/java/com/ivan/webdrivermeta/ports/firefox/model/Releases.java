package com.ivan.webdrivermeta.ports.firefox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Releases(List<Release> releases) {
    public Releases {
    }
}
