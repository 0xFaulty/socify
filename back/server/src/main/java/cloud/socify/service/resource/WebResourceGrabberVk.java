package cloud.socify.service.resource;

public class WebResourceGrabberVk extends WebResourceGrabber {

    public WebResourceGrabberVk() {
        super("vk", "vk.com");
    }

    @Override
    public Runnable getNextTask() {
        return () -> {};
    }

}
