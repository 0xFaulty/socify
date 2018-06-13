package cloud.socify.dao;

import cloud.socify.entity.User;

public interface UserDao {

    User getUser(String sessionKey);

    boolean exists(String sessionKey);
}
