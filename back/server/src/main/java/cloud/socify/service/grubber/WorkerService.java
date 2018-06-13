package cloud.socify.service.grubber;

import cloud.socify.service.resource.WebResourceGrabber;

import java.util.List;

public class WorkerService implements Runnable {

    private List<WebResourceGrabber> webResourceGrabbers;

    public WorkerService(List<WebResourceGrabber> webResourceGrabbers) {
        this.webResourceGrabbers = webResourceGrabbers;
    }

    public void addResource(WebResourceGrabber webResourceGrabber) {
        this.webResourceGrabbers.add(webResourceGrabber);
    }

    public void removeResource(WebResourceGrabber webResourceGrabber) {
        this.webResourceGrabbers.remove(webResourceGrabber);
    }

    public void run() {
        for (WebResourceGrabber webResourceGrabber : webResourceGrabbers) {
            Runnable task = webResourceGrabber.getNextTask();
            if (task != null) {
                task.run();
            }
        }
    }

}
