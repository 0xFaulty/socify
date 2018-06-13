package cloud.socify.controller;

import cloud.socify.entity.ApiError;
import cloud.socify.entity.ApiVersion;
import cloud.socify.service.api.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class ApiVersionController {

    private final static Logger LOG = LoggerFactory.getLogger(ApiVersionController.class);

    @Autowired
    private ApiService apiService;

    @RequestMapping(value = "/version", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getApiVersion() {
        try {
            return new ResponseEntity<>(new ApiVersion(apiService.getVersion()), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("getApiVersion() error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

}
