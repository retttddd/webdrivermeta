package com.ivan.webdrivermeta.ports.firefox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(String name, String browser_download_url) {

}
