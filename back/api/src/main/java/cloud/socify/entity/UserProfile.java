package cloud.socify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    String userId;
    List<Resource> resources;
    Map<String, Channel> resourceIdToChannel;
}
