package cloud.socify.service.api;

import cloud.socify.entity.PublicKey;
import cloud.socify.entity.UserProfile;

public interface AuthService {

    PublicKey getPublicKey(String json);

    UserProfile login(String json);

    UserProfile register(String json);

}
