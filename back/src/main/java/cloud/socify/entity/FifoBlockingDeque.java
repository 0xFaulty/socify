package cloud.socify.entity;

import java.util.concurrent.LinkedBlockingDeque;

public class FifoBlockingDeque extends LinkedBlockingDeque<Runnable> {
    public FifoBlockingDeque(int capacity) {
        super(capacity);
    }

    @Override
    public boolean offer(Runnable t) {
        return super.offerFirst(t);
    }

    @Override
    public Runnable remove() {
        return super.removeFirst();
    }

}
