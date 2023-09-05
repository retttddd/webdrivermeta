package com.ivan.webdrivermeta.controller;

import com.ivan.webdrivermeta.model.DriverMeta;
import com.ivan.webdrivermeta.service.DriveMetaException;
import com.ivan.webdrivermeta.service.DriverMetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverMetaController {
    Logger logger = LoggerFactory.getLogger(DriverMetaController.class);
    @Autowired
    private DriverMetaService driverMetaService;

    @GetMapping("/getDriverUrl")
    public DriverMeta getDriverUrl(@RequestParam(name = "browser") String browser,
                                   @RequestParam(name = "version") String ver,
                                   @RequestParam(name = "platform") String platform) {

        try {
            logger.info("controller: call to endpoint");
            return this.driverMetaService.getDriverMeta(browser, ver, platform);
        } catch (DriveMetaException e) {
            logger.error("controller: failed to find the link", e);
            throw new LinkNotFoundException(e.getMessage());
        }
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "link not found")
    public class LinkNotFoundException extends RuntimeException {
        public LinkNotFoundException(String message) {
            super(message);
        }
    }
}
