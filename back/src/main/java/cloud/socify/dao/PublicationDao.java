package cloud.socify.dao;

import cloud.socify.entity.Publication;
import cloud.socify.entity.User;

import java.util.List;

public interface PublicationDao {

    List<Publication> getPublications(User user);

    void addPublications(List<Publication> publications);
}
