package cloud.socify.controller;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.entity.Resource;
import cloud.socify.service.api.DataReceiveService;
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
@RequestMapping(value = "/api/v1.0/channel")
public class ChannelController {

    private final static Logger LOG = LoggerFactory.getLogger(ChannelController.class);

    private final UserProfileService userProfileService;
    private final DataReceiveService dataReceiveService;

    @Autowired
    public ChannelController(DataReceiveService dataReceiveService, UserProfileService userProfileService) {
        this.dataReceiveService = dataReceiveService;
        this.userProfileService = userProfileService;
    }

    @GetMapping(value = "preview", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Publication> preview(HttpServletRequest request) throws Exception {
        return dataReceiveService.previewChannel(ServletUtils.getBody(request));
    }

    @PostMapping(value = "disconnect")
    public void disconnect(HttpServletRequest request) throws Exception {
        userProfileService.disconnectChannel(ServletUtils.getBody(request));
    }

    @PostMapping(value = "connect")
    public void connect(HttpServletRequest request) throws Exception {
        userProfileService.connectChannel(ServletUtils.getBody(request));
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Channel> list(HttpServletRequest request) throws Exception {
        return userProfileService.listChannel(ServletUtils.getBody(request));
    }

    @PostMapping(value = "subscribe")
    public void subscribe(HttpServletRequest request) throws Exception {
        userProfileService.subscribeChannel(ServletUtils.getBody(request));
    }

    @PostMapping(value = "unsubscribe")
    public void unsubscribe(HttpServletRequest request) throws Exception {
        userProfileService.unsubscribeChannel(ServletUtils.getBody(request));
    }

}
