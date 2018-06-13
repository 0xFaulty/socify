package cloud.socify.service.resource;

public abstract class WebResourceGrabber {

    private String name;
    private String url;

    public WebResourceGrabber(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public abstract Runnable getNextTask();

}
