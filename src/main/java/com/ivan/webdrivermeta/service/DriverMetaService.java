package com.ivan.webdrivermeta.service;

import com.ivan.webdrivermeta.model.DriverMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class DriverMetaService {


    Logger logger = LoggerFactory.getLogger(DriverMetaService.class);

    public DriverMeta getDriverMeta(String browser,
                                    String ver,
                                    String platform)throws DriveMetaException{
        logger.info("CALL TO METADRIVER Service");
        if (browser.equals("Chrome1")) {
            return new DriverMeta(ver+browser+platform);
        }
        throw new DriveMetaException("browser is not supported: " + browser);
    }
}
