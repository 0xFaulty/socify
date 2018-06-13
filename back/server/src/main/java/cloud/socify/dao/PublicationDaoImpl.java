package cloud.socify.dao;

import cloud.socify.entity.Publication;
import cloud.socify.entity.User;

import java.util.Collections;
import java.util.List;

public class PublicationDaoImpl implements PublicationDao {

    @Override
    public List<Publication> getPublications(User user) {
        return Collections.emptyList();
    }

    @Override
    public void addPublications(List<Publication> publications) {

    }

}
