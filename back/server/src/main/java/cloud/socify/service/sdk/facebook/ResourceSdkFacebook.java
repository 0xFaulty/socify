package cloud.socify.service.sdk.facebook;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.service.sdk.ResourceSdk;

import java.util.Collections;
import java.util.List;


public class ResourceSdkFacebook implements ResourceSdk {

    @Override
    public List<Publication> getPublications(Channel channel, int count, int offset) {
        return Collections.emptyList();
    }

}
