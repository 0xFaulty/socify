package cloud.socify.service.api;

import cloud.socify.entity.PublicKey;
import cloud.socify.entity.UserProfile;

public class AuthServiceImpl implements AuthService {

    @Override
    public PublicKey getPublicKey(String json) {
        return new PublicKey();
    }

    @Override
    public UserProfile login(String json) {
        return new UserProfile();
    }

    @Override
    public UserProfile register(String json) {
        return new UserProfile();
    }
}
