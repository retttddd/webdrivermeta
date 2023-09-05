package com.ivan.webdrivermeta.ports.chrome;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Download(
        String platform,
        String url
) {}
