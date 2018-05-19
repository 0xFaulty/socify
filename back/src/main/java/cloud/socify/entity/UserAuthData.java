package cloud.socify.entity;

public class UserAuthData {

    private String userId = "";
    private String accessToken = "";

    public UserAuthData() {
    }

    public UserAuthData(String userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }

    public UserAuthData(int userId, String accessToken) {
        this.userId = Integer.toString(userId);
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
