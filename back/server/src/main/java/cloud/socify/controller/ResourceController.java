package cloud.socify.controller;

import cloud.socify.entity.Resource;
import cloud.socify.service.api.UserProfileService;
import cloud.socify.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1.0/resource")
public class ResourceController {

    private final static Logger LOG = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping(value = "disconnect")
    public void disconnect(HttpServletRequest request) throws Exception {
        userProfileService.disconnectResource(ServletUtils.getBody(request));
    }

    @PostMapping(value = "connect")
    public void connect(HttpServletRequest request) throws Exception {
        userProfileService.connectResource(ServletUtils.getBody(request));
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Resource> list(HttpServletRequest request) throws Exception {
        return userProfileService.listResource(ServletUtils.getBody(request));
    }

}
