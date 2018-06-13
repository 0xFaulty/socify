package cloud.socify.service.sdk;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;

import java.util.List;

public interface ResourceSdk {

    List<Publication> getPublications(Channel channel, int count, int offset);

}
