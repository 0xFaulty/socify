package cloud.socify.controller;

import cloud.socify.entity.Publication;
import cloud.socify.service.api.DataReceiveService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "api/v1.0")
public class DataReceiveController {

    private DataReceiveService dataReceiveService;

    public DataReceiveController(DataReceiveService dataReceiveService) {
        this.dataReceiveService = dataReceiveService;
    }

    @GetMapping(value = "publication", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Publication> getNewsFeed() {
        return dataReceiveService.getNewsFeed("");
    }

}
