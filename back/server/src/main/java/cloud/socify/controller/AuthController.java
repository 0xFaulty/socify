package cloud.socify.controller;

import cloud.socify.entity.PublicKey;
import cloud.socify.entity.UserProfile;
import cloud.socify.service.api.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1.0/auth")
public class AuthController {

    private final static Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @GetMapping(value = "/pk", produces = MediaType.APPLICATION_JSON_VALUE)
    public PublicKey getPublicKey() {
        return authService.getPublicKey("");
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserProfile login() {
        return authService.login("");
    }

    @GetMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserProfile register() {
        return authService.register("");
    }

}
