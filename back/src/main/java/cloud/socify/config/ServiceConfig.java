package cloud.socify.config;

import cloud.socify.dao.SubscriptionDao;
import cloud.socify.dao.UserDao;
import cloud.socify.service.api.DataReceiveService;
import cloud.socify.service.api.DataReceiveServiceImpl;
import cloud.socify.service.grubber.WorkerService;
import cloud.socify.service.resource.WebResourceGrabberFacebook;
import cloud.socify.service.resource.WebResourceGrabberVk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ServiceConfig {

    @Bean
    public WorkerService workerService() {
        return new WorkerService(Arrays.asList(new WebResourceGrabberVk(), new WebResourceGrabberFacebook()));
    }

    @Bean
    public DataReceiveService dataReceiveService(SubscriptionDao subscriptionDao, UserDao userDao) {
        return new DataReceiveServiceImpl(subscriptionDao, userDao);
    }

}
