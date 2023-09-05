package com.ivan.webdrivermeta.ports.chrome.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Download(
        String platform,
        String url
) {}
