package cloud.socify.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data
class ApiError {
    private String error;
}
