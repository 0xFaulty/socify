package cloud.socify.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    private String id;
    private String name;
    private String uri;
    private String imageSource;
    private boolean notification;
    private boolean available;
    private Resource resource;
}
