package com.ivan.webdrivermeta.service;

import com.ivan.webdrivermeta.model.DriverMeta;
import com.ivan.webdrivermeta.ports.chrome.ChromeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DriverMetaService {
    private final static String BROWSER_CHROME = "Chrome";
    private final static String BROWSER_FF = "FireFox";
    private final static String BROWSER_EDGE = "Edge";

    Logger logger = LoggerFactory.getLogger(DriverMetaService.class);
    @Autowired
    private ChromeClient chromeClient;
    public DriverMeta getDriverMeta(String browser,
                                    String ver,
                                    String platform)throws DriveMetaException {
        logger.info("CALL TO METADRIVER Service");
        switch (browser) {
            case BROWSER_CHROME:
                return new DriverMeta(this.chromeClient.getDriverUrl(ver, platform));
            case BROWSER_EDGE:
                throw new DriveMetaException("browser is not supported: " + browser);
            case BROWSER_FF:
                throw new DriveMetaException("browser is not supported: " + browser);
            default:
                throw new DriveMetaException("browser is not supported: " + browser);
        }
    }
}
