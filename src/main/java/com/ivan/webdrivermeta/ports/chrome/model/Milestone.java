package com.ivan.webdrivermeta.ports.chrome.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Milestone(String  milestone,
                        String version,
                        String revision,
                        Map<String, List<Download>> downloads) { }
