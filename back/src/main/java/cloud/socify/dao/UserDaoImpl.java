package cloud.socify.dao;

import cloud.socify.entity.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String sessionKey) {
        return new User();
    }

    @Override
    public boolean exists(String sessionKey) {
        return true;
    }
}
