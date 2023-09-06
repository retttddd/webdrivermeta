package com.ivan.webdrivermeta.ports.chrome;


import com.ivan.webdrivermeta.ports.chrome.model.Download;
import com.ivan.webdrivermeta.ports.chrome.model.Milestone;
import com.ivan.webdrivermeta.ports.chrome.model.Milestones;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ChromeClient {

    private final RestTemplate restTemplate;
    private final String serviceUrl;

    public ChromeClient(RestTemplate restTemplate,
                        @Value("${chrome.api.url}") String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl;
    }

    public String getDriverUrl(String ver, String platform) throws ChromeClientException {
        Milestones res = restTemplate.getForObject(
                this.serviceUrl, Milestones.class);
        Milestone prRes = res.milestones().get(ver);

        if (prRes == null) {
            throw new ChromeClientException("chrome client: no such a version");
        }
        List<Download> resList = prRes.downloads().get("chrome");
        if (resList == null) {
            throw new ChromeClientException("chrome client: no download link are available");
        }

        for (Download d : resList) {
            if (d.platform() != null && d.platform().equals(platform)) {
                return d.url();
            }
        }
        throw new ChromeClientException("chrome client: download url not found");
    }
}
