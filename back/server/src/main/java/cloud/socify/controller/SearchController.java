package cloud.socify.controller;

import cloud.socify.entity.UserProfile;
import cloud.socify.service.api.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1.0/search")
public class SearchController {

    private final static Logger LOG = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping(value = "filter")
    public void addFilter() {
        userProfileService.addFilter("");
    }

    @DeleteMapping(value = "filter")
    public void removeFilter() {
        userProfileService.removeFilter("");
    }

}
