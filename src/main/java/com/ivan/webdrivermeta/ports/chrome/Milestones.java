package com.ivan.webdrivermeta.ports.chrome;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Milestones(String timestamp, Map<String, Milestone> milestones) {
}
