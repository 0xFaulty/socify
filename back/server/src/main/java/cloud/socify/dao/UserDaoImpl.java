package cloud.socify.dao;

import cloud.socify.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.DSLContext;
//import cloud.socify.jooq.Tables.USER_RESOURCES;

public class UserDaoImpl implements UserDao {

    private final ObjectMapper objectMapper;
    private final DSLContext dslContext;

    public UserDaoImpl(ObjectMapper objectMapper, DSLContext dslContext) {
        this.objectMapper = objectMapper;
        this.dslContext = dslContext;
    }

    @Override
    public User getUser(String sessionKey) {
//        dslContext.selectFrom(USER_RESOURCES);
        return new User();
    }

    @Override
    public boolean exists(String sessionKey) {
        return true;
    }
}
