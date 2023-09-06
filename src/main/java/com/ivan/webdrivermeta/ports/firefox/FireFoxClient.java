package com.ivan.webdrivermeta.ports.firefox;


import com.ivan.webdrivermeta.ports.firefox.model.Asset;
import com.ivan.webdrivermeta.ports.firefox.model.Release;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FireFoxClient {
    private final RestTemplate restTemplate;
    private final String serviceUrl;

    public FireFoxClient(RestTemplate restTemplate,
                         @Value("${firefox.api.url}") String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl;
    }

    public String getDriverUrl(String ver, String platform) throws FireFoxClientException {
        ResponseEntity<Release[]> res = restTemplate.getForEntity(
                this.serviceUrl, Release[].class);

        for (Release r : Objects.requireNonNull(res.getBody())) {
            if (r.name().equals(ver)) {
                for (Asset a : Objects.requireNonNull(r.assets())) {
                    if (isAssetFromPlatform(a, platform)) {
                        return a.browser_download_url();
                    }
                }
                throw new FireFoxClientException("firefox client: could not find link for platform: " + platform);
            }
        }
        throw new FireFoxClientException("firefox client: could not find version: " + ver);
    }

    private boolean isAssetFromPlatform(Asset a, String platform) {
        Pattern driverFileNamePattern = Pattern.compile("geckodriver-v\\d+\\.\\d+\\.\\d+-(linux-aarch64|macos|macos-aarch64|linux32|linux64|win-aarch64|win32|win64)\\.(tar.gz|zip)$");
        Matcher driverFileNameMatcher = driverFileNamePattern.matcher(a.name());
        if (driverFileNameMatcher.find()) {
            return driverFileNameMatcher.group(1).equals(platform);
        }
        return false;
    }

    /**
     * todo get rid of hardcoded calculation of version
     */
    public String getDriverVersion(String milestoneVersion) throws FireFoxClientException {
        return switch (milestoneVersion) {
            case "91" -> "0.31.0";
            case "92" -> "0.31.0";
            case "95" -> "0.31.0";
            case "96" -> "0.31.0";
            case "97" -> "0.31.0";
            case "98" -> "0.31.0";
            case "99" -> "0.31.0";
            case "93" -> "0.31.0";
            case "94" -> "0.31.0";
            case "101" -> "0.31.0";
            case "102" -> "0.32.2";
            case "103" -> "0.32.2";
            case "104" -> "0.32.2";
            case "105" -> "0.32.2";
            case "100" -> "0.32.2";
            case "106" -> "0.32.2";
            case "107" -> "0.32.2";
            case "108" -> "0.32.2";
            case "109" -> "0.32.2";
            case "110" -> "0.32.2";
            case "111" -> "0.32.2";
            case "112" -> "0.32.2";
            case "113" -> "0.33.0";
            case "114" -> "0.33.0";
            case "115" -> "0.33.0";
            case "116" -> "0.33.0";
            case "117" -> "0.33.0";
            default -> "0.33.0";
        };
    }
}
