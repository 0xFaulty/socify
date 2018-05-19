package cloud.socify.dao;

import cloud.socify.entity.Source;
import cloud.socify.entity.User;

import java.util.List;

public interface DataSourceDao {

    List<Source> getSources(User user);
}
