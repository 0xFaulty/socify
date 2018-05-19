package cloud.socify.dao;

import cloud.socify.entity.Source;
import cloud.socify.entity.User;

import java.util.Collections;
import java.util.List;

public class DataSourceDaoImpl implements DataSourceDao {

    @Override
    public List<Source> getSources(User user) {
        return Collections.emptyList();
    }

}
