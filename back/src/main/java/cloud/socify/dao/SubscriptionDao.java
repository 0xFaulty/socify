package cloud.socify.dao;

import cloud.socify.entity.Channel;
import cloud.socify.entity.User;

import java.util.List;

public interface SubscriptionDao {

    List<Channel> getSubscription(User user);

}
