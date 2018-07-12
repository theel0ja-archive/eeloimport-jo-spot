package io.eelo.spot.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    static final LinkedBlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private static final List<Waiter> waiters = new ArrayList<>();

    public static void init(int numberOfThreads) {
        while (waiters.size() < numberOfThreads) {
            final Waiter waiter = new Waiter();
            new Thread(waiter).start();
            waiters.add(waiter);
        }
        while (waiters.size() > numberOfThreads) {
            waiters.remove(0).stop();
        }
    }

    public static void run(final Runnable runnable) {
        tasks.add(runnable);
    }

}
