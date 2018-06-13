package cloud.socify.utils;

import java.util.Collection;
import java.util.StringJoiner;
import java.util.UUID;

public class Uuids {

    /**
     * Converts all the UUIDs into comma separate list of values with
     * Postresql cast to uuid type.
     *
     * @param uuids list of uuids to join
     * @return concatenated and casted list of uuids for jdbc query
     */
    public static String uuidsToString(Collection<UUID> uuids) {
        StringJoiner joiner = new StringJoiner(",");
        for (UUID uuid : uuids) {
            joiner.add("'" + uuid + "'::uuid");
        }
        return joiner.toString();
    }
}
