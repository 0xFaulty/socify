package cloud.socify.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class ServletUtils {

    public static String getBody(HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining());
    }

}
