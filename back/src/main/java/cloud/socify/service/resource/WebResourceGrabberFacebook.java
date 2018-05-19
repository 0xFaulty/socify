package cloud.socify.service.resource;

public class WebResourceGrabberFacebook extends WebResourceGrabber {

    public WebResourceGrabberFacebook() {
        super("facebook", "facebook.com");
    }

    @Override
    public Runnable getNextTask() {
        return () -> {};
    }

}
