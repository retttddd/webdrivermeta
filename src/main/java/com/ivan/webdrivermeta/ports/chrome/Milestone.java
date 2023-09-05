package com.ivan.webdrivermeta.ports.chrome;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SplittableRandom;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Milestone(String  milestone,
                        String version,
                        String revision,
                        Map<String, List<Download>> downloads) { }
