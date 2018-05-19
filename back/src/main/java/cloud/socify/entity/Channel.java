package cloud.socify.entity;

public class Channel {

    private String id;
    private String name;
    private String uri;
    private String imageSource;
    private Source source;

    public Channel() {
    }

    public Channel(String id, String name, String uri, String imageSource, Source source) {
        this.id = id;
        this.name = name;
        this.uri = uri;
        this.imageSource = imageSource;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", imageSource='" + imageSource + '\'' +
                ", source=" + source +
                '}';
    }
}
