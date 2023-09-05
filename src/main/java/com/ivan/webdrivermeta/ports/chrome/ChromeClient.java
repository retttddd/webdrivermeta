package com.ivan.webdrivermeta.ports.chrome;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ChromeClient {

    public ChromeClient(RestTemplate restTemplate,
                        @Value("${chrome.api.url}") String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl;
    }

    private RestTemplate restTemplate;
    private String serviceUrl;

    public String getDriverUrl(String ver, String platform) {
        Milestones res = restTemplate.getForObject(
                this.serviceUrl, Milestones.class);
        List<Download> resList = res.milestones().get(ver).downloads().get("chrome");
        for (Download d: resList) {
            if (d.platform() != null && d.platform().equals(platform)){
                return d.url();
            }

        }
        throw new RuntimeException("download url not found");
    }
}
