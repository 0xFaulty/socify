package cloud.socify.service.sdk;

import cloud.socify.entity.Channel;
import cloud.socify.service.sdk.facebook.ResourceSdkFacebook;
import cloud.socify.service.sdk.instagram.ResourceSdkInstagram;
import cloud.socify.service.sdk.vk.ResourceSdkVk;

import java.util.HashMap;
import java.util.Map;

public class SdkDispatcher {

    private static Map<SdkType, ResourceSdk> sdkMap = new HashMap<>();

    static {
        sdkMap.put(SdkType.VK, new ResourceSdkVk());
        sdkMap.put(SdkType.INSTAGRAM, new ResourceSdkInstagram());
        sdkMap.put(SdkType.FACEBOOK, new ResourceSdkFacebook());
    }

    public static ResourceSdk getSdk(Channel channel) {
        return sdkMap.get(SdkType.byName(channel.getResource().getName()));
    }
}
