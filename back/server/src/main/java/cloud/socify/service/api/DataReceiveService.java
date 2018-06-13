package cloud.socify.service.api;

import cloud.socify.entity.Publication;

import java.util.List;

public interface DataReceiveService {

    List<Publication> getNewsFeed(String sessionKey);

    List<Publication> previewChannel(String body);
}
