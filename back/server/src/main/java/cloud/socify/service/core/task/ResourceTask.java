package cloud.socify.service.core.task;

import cloud.socify.dao.PublicationDao;
import cloud.socify.service.core.wrapper.ResourceWrapper;

public class ResourceTask implements Runnable {

    private PublicationDao publicationDao;
    private ResourceWrapper wrapper;

    public ResourceTask(PublicationDao publicationDao, ResourceWrapper wrapper) {
        this.publicationDao = publicationDao;
        this.wrapper = wrapper;
    }

    @Override
    public void run() {
        publicationDao.addPublications(wrapper.getPublications());
    }

}
