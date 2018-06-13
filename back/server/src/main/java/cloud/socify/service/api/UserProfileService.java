package cloud.socify.service.api;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.entity.Resource;
import cloud.socify.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile getUserProfile(String json);

    void updateResource(String json);

    void updateChannel(String json);

    void updateNotification(String json);

    void addFilter(String json);

    void removeFilter(String json);

    void disconnectResource(String body);

    void connectResource(String body);

    List<Resource> listResource(String body);

    void disconnectChannel(String body);

    void connectChannel(String body);

    List<Channel> listChannel(String body);

    void subscribeChannel(String body);

    void unsubscribeChannel(String body);
}
