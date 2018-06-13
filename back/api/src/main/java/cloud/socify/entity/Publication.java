package cloud.socify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    private long date;
    private String imageSource;
    private String text;
    private Channel channel;
}
