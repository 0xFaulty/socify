package cloud.socify.service.sdk;

public enum SdkType {
    VK("vk"),
    INSTAGRAM("instagram"),
    FACEBOOK("facebook");

    private String name;

    SdkType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SdkType byName(String name) {
        for (SdkType type : values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        throw new IllegalStateException("No enum value for " + name);
    }
}
