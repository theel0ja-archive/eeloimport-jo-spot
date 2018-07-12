package io.eelo.spot.threadPool;

import io.eelo.spot.TestUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class ThreadPoolTest {

    @Test
    public void changeThreadPoolSize() throws Exception {
        ThreadPool.init(10);
        List waiters = (List) TestUtils.accessToPrivateField(new ThreadPool(), "waiters", null);
        assertSame(waiters.size(), 10);
        ThreadPool.init(20);
        waiters = (List) TestUtils.accessToPrivateField(new ThreadPool(), "waiters", null);
        assertSame(waiters.size(), 20);
        ThreadPool.init(5);
        waiters = (List) TestUtils.accessToPrivateField(new ThreadPool(), "waiters", null);
        assertSame(waiters.size(), 5);
    }

    @Test
    public void executeSomeTasks() throws InterruptedException {
        ThreadPool.init(5);
        final int[] i = {0};
        final Object o = new Object();
        final Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                synchronized (o) {
                    i[0]++;
                    if (i[0] == 10) {
                        o.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        final long time = System.currentTimeMillis();
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        ThreadPool.run(runnable);
        assertTrue(System.currentTimeMillis() - time < 10);
        synchronized (o) {
            o.wait();
        }
        final long diff = time + 2000 - System.currentTimeMillis();
        assertTrue(diff < 10 && diff > -10);
    }

}