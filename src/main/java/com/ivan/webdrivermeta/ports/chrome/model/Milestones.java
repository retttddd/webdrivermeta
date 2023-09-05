package com.ivan.webdrivermeta.ports.chrome.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Milestones(String timestamp, Map<String, Milestone> milestones) {
}
