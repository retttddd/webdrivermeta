package com.ivan.webdrivermeta.service;

import com.ivan.webdrivermeta.model.DriverMeta;
import com.ivan.webdrivermeta.ports.chrome.ChromeClient;
import com.ivan.webdrivermeta.ports.chrome.ChromeClientException;
import com.ivan.webdrivermeta.ports.firefox.FireFoxClient;
import com.ivan.webdrivermeta.ports.firefox.FireFoxClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DriverMetaService {
    private final static String BROWSER_CHROME = "Chrome";
    private final static String BROWSER_FF = "FireFox";
    private final static String BROWSER_EDGE = "Edge";

    Logger logger = LoggerFactory.getLogger(DriverMetaService.class);
    @Autowired
    private ChromeClient chromeClient;

    @Autowired
    private FireFoxClient fireFoxClient;

    @Cacheable("driversMeta")
    public DriverMeta getDriverMeta(String browser,
                                    String ver,
                                    String platform) throws DriveMetaException {
        logger.info("service: call to getDriverMeta");
        switch (browser) {
            case BROWSER_CHROME:
                try {
                    return new DriverMeta(this.chromeClient.getDriverUrl(extractMilestoneVersion(ver), platform));
                } catch (ChromeClientException e) {
                    throw new DriveMetaException(e.getMessage());
                }
            case BROWSER_EDGE:
                throw new DriveMetaException("service: browser is not supported: " + browser);
            case BROWSER_FF:
                try {
                    return new DriverMeta(
                            this.fireFoxClient.getDriverUrl(
                                    this.fireFoxClient.getDriverVersion(
                                            extractMilestoneVersion(ver)),
                                    platform));
                } catch (FireFoxClientException e) {
                    throw new DriveMetaException(e.getMessage());
                }
            default:
                throw new DriveMetaException("service: browser is not supported: " + browser);
        }
    }

    private String extractMilestoneVersion(String browserVersion) throws DriveMetaException {
        Pattern digitRegex = Pattern.compile("^(\\d+)");
        Matcher milestoneVersionMatcher = digitRegex.matcher(browserVersion);
        if (milestoneVersionMatcher.find()) {
            return milestoneVersionMatcher.group(0);
        }
        throw new DriveMetaException("service: error extracting milestone version");
    }

    @CacheEvict(value = "driversMeta", allEntries = true)
    @Scheduled(fixedRateString = "${caching.spring.driversMetaTTL}")
    public void emptyDriversMetaCache() {
        logger.info("emptying drivers meta cache");
    }
}


