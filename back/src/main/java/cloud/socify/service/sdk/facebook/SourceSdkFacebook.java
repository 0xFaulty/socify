package cloud.socify.service.sdk.facebook;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.service.sdk.SourceSdk;

import java.util.Collections;
import java.util.List;


public class SourceSdkFacebook implements SourceSdk {

    @Override
    public List<Publication> getPublications(Channel channel, int count, int offset) {
        return Collections.emptyList();
    }

}
