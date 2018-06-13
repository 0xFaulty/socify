package cloud.socify.dao;

import cloud.socify.entity.Resource;
import cloud.socify.entity.User;

import java.util.List;

public interface DataResourceDao {

    List<Resource> getResources(User user);
}
