package cloud.socify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordFilter {
    String name;
    List<String> includeWords;
    List<String> excludeWords;
}
