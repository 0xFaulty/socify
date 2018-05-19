package cloud.socify.service.sdk;

import cloud.socify.entity.Channel;
import cloud.socify.service.sdk.facebook.SourceSdkFacebook;
import cloud.socify.service.sdk.instagram.SourceSdkInstagram;
import cloud.socify.service.sdk.vk.SourceSdkVk;

import java.util.HashMap;
import java.util.Map;

public class SdkDispatcher {

    private static Map<SdkType, SourceSdk> sdkMap = new HashMap<>();

    static {
        sdkMap.put(SdkType.VK, new SourceSdkVk());
        sdkMap.put(SdkType.INSTAGRAM, new SourceSdkInstagram());
        sdkMap.put(SdkType.FACEBOOK, new SourceSdkFacebook());
    }

    public static SourceSdk getSdk(Channel channel) {
        return sdkMap.get(SdkType.byName(channel.getSource().getName()));
    }
}
