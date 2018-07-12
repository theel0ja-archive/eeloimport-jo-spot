package io.eelo.spot.threadPool;

public abstract class InfiniteLoop implements Runnable {

    private boolean running = true;
    private int interval = 0;

    public abstract void loop() throws Exception;

    @Override
    public void run() {
        while (running) {
            try {
                loop();
                if (interval > 0) {
                    Thread.sleep(interval);
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void stop() {
        running = false;
    }
}
