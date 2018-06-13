package cloud.socify.service.api;

import cloud.socify.controller.AppErrorController;
import cloud.socify.dao.SubscriptionDao;
import cloud.socify.dao.UserDao;
import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.entity.User;
import cloud.socify.exeption.WrongSessionKeyException;
import cloud.socify.service.sdk.SdkDispatcher;
import cloud.socify.service.sdk.ResourceSdk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReceiveServiceImpl implements DataReceiveService {

    private final static Logger LOG = LoggerFactory.getLogger(AppErrorController.class);

    private SubscriptionDao subscriptionDao;
    private UserDao userDao;

    public DataReceiveServiceImpl(SubscriptionDao subscriptionDao, UserDao userDao) {
        this.subscriptionDao = subscriptionDao;
        this.userDao = userDao;
    }

    @Override
    public List<Publication> getNewsFeed(String sessionKey) {
        if (!userDao.exists(sessionKey)) {
            throw new WrongSessionKeyException();
        }

        List<Publication> publications = new ArrayList<>();
        List<Channel> subscription = subscriptionDao.getUserChannels(new User());
        for (Channel channel : subscription) {
            try {
                ResourceSdk sdk = SdkDispatcher.getSdk(channel);
                publications.addAll(sdk.getPublications(channel, 10, 0));
            } catch (Exception e) {
                LOG.error("", e);
            }
        }

        publications.sort((o1, o2) -> Long.compare(o2.getDate(), o1.getDate()));

        return publications;
    }

    @Override
    public List<Publication> previewChannel(String body) {
        return Collections.emptyList();
    }


}
