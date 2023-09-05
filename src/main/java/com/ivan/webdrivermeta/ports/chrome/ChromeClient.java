package com.ivan.webdrivermeta.ports.chrome;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChromeClient {

    public ChromeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;

    public String getDriverUrl(String ver, String platform) {
        String serviceUrl = "https://googlechromelabs.github.io/chrome-for-testing/latest-versions-per-milestone-with-downloads.json";
        Milestones res = restTemplate.getForObject(
                serviceUrl, Milestones.class);
        return "eqwqe";
    }
}
