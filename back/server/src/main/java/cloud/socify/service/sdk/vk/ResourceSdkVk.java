package cloud.socify.service.sdk.vk;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.entity.Resource;
import cloud.socify.entity.UserAuthData;
import cloud.socify.service.sdk.ResourceSdk;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import com.vk.api.sdk.queries.groups.GroupField;
import com.vk.api.sdk.queries.users.UserField;

import java.util.ArrayList;
import java.util.List;

public class ResourceSdkVk implements ResourceSdk {

    private VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());
    private UserAuthData userAuthData = new UserAuthData(30535790, "3bf8a77300955222a6912fa455f5228964a72e06e164105634a7896fc9cac0a0a4d5429b573a98adf2a7e");

    public UserAuthData getUserAuthData(String code) {
        try {
            final int APP_ID = 6080102;
            final String REDIRECT_URI = "https://oauth.vk.com/blank.html";
            final String CLIENT_SECRET = "r6YsJq31mlWiNONX64Mq";
            UserAuthResponse authResponse = vk.oauth()
                    .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                    .execute();
            return new UserAuthData(authResponse.getUserId(), authResponse.getAccessToken());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Publication> getPublications(Channel channel, int count, int offset) {
        try {
            UserActor actor = new UserActor(userAuthData.getUserId(), userAuthData.getAccessToken());
            GetResponse response = vk.wall().get(actor)
                    .ownerId(Integer.parseInt(channel.getId()))
                    .count(count)
                    .offset(offset)
                    .execute();
            return TransformerVk.responseToPublications(response, channel);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Channel> getChannels(List<String> groupNames, UserAuthData userAuthData, Resource resource) {
        try {
            UserActor actor = new UserActor(userAuthData.getUserId(), userAuthData.getAccessToken());
            List<GroupFull> groups = vk.groups().getById(actor)
                    .groupIds(groupNames)
                    .fields(GroupField.MEMBERS_COUNT)
                    .execute();
            return TransformerVk.groupsToChannels(groups, resource);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<UserXtrCounters> getUserInfo(List<String> channelIds, UserAuthData userAuthData) {
        try {
            UserActor actor = new UserActor(userAuthData.getUserId(), userAuthData.getAccessToken());
            return new ArrayList<>(vk.users().get(actor)
                                           .userIds(channelIds)
                                           .fields(UserField.ABOUT)
                                           .fields(UserField.PHOTO_MAX_ORIG)
                                           .execute());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
