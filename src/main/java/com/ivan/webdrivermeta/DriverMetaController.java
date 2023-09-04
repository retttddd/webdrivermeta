package com.ivan.webdrivermeta;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverMetaController {
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "link not found")
    public class LinkNotFoundException extends RuntimeException {
    }
    @GetMapping("/getDriverUrl")
    public DriverMeta getDriverUrl(@RequestParam(name = "browser") String browser,
                                   @RequestParam(name = "version")String ver,
                                   @RequestParam(name = "platform") String platform){
        if (browser.equals("Chrome1")) {
            return new DriverMeta(ver+browser+platform);
        }
        throw new LinkNotFoundException();
    }
}
