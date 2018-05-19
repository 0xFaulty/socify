package cloud.socify.entity;

public class Publication {

    private int date;
    private String imageSource;
    private String text;
    private Channel channel;

    public Publication() {
    }

    public Publication(int date, String imageSource, String text, Channel channel) {
        this.date = date;
        this.imageSource = imageSource;
        this.text = text;
        this.channel = channel;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "date=" + date +
                ", imageSource='" + imageSource + '\'' +
                ", text='" + text + '\'' +
                ", channel=" + channel +
                '}';
    }
}
