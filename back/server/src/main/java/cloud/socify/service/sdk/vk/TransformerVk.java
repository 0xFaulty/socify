package cloud.socify.service.sdk.vk;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.entity.Resource;
import com.vk.api.sdk.objects.docs.Doc;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.wall.WallpostAttachment;
import com.vk.api.sdk.objects.wall.WallpostAttachmentType;
import com.vk.api.sdk.objects.wall.WallpostFull;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransformerVk {

    private static final String GROUP_PREFIX = "https://vk.com/club";

    public static List<Publication> responseToPublications(GetResponse response, Channel channel) {
        List<Publication> publications = new ArrayList<>();
        for (WallpostFull post : response.getItems()) {
            Pair<Boolean, String> imgRes = getImage(post).orElse(Pair.of(false, ""));
            if (!imgRes.getFirst()) {
                continue;
            }
            String photo = imgRes.getSecond();
            String text = post.getText();
            if (photo.equals("") && text.equals("")) {
                continue;
            }
            publications.add(new Publication(post.getDate(), photo, text, channel));
        }
        return publications;
    }

    private static Optional<Pair<Boolean, String>> getImage(WallpostFull post) {
        List<WallpostAttachment> attachments = post.getAttachments();
        if (attachments != null) {
            if (!attachments.isEmpty()) {
                for (WallpostAttachment attachment : attachments) {
                    if (attachment.getType() == WallpostAttachmentType.PHOTO) {
                        Optional<String> maxPhotoOpt = getMaxPhoto(attachment.getPhoto());
                        if (maxPhotoOpt.isPresent()) {
                            return Optional.of(Pair.of(true, maxPhotoOpt.get()));
                        }
                    }
                    if (attachment.getType() == WallpostAttachmentType.DOC) {
                        Optional<String> docPhotoOpt = getDocPhoto(attachment.getDoc());
                        if (docPhotoOpt.isPresent()) {
                            return Optional.of(Pair.of(true, docPhotoOpt.get()));
                        }
                    }
                }
                return Optional.of(Pair.of(false, ""));
            }
        }

        return Optional.empty();
    }

    private static Optional<String> getDocPhoto(Doc doc) {
        return Optional.of(doc.getUrl());
    }

    private static Optional<String> getMaxPhoto(Photo photo) {
        if (photo == null) {
            return Optional.empty();
        }

        String photo2560 = photo.getPhoto2560();
        if (photo2560 != null) {
            return Optional.of(photo2560);
        }
        String photo1280 = photo.getPhoto1280();
        if (photo1280 != null) {
            return Optional.of(photo1280);
        }
        String photo807 = photo.getPhoto807();
        if (photo807 != null) {
            return Optional.of(photo807);
        }
        String photo604 = photo.getPhoto604();
        if (photo604 != null) {
            return Optional.of(photo604);
        }

        return Optional.empty();
    }

    public static List<Channel> groupsToChannels(List<GroupFull> groups, Resource resource) {
        List<Channel> channels = new ArrayList<>();
        for (GroupFull group : groups) {
            Channel channel = Channel.builder()
                    .id(group.getId())
                    .name(group.getName())
                    .uri(GROUP_PREFIX + group.getId())
                    .imageSource(group.getPhoto200())
                    .notification(false)
                    .available(true)
                    .resource(resource)
                    .build();
            channels.add(channel);
        }

        return channels;
    }

}
