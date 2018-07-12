package io.eelo.spot.threadPool;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class InfiniteLoopTest {


    @Test
    public void test() throws InterruptedException {
        final int[] i = {0};
        final InfiniteLoop infiniteLoop = new InfiniteLoop() {
            @Override
            public void loop() {
                i[0]++;
            }
        };
        infiniteLoop.setInterval(10);
        final Thread thread = new Thread(infiniteLoop);
        thread.start();
        Thread.sleep(100);
        assertTrue(thread.isAlive());
        infiniteLoop.stop();
        Thread.sleep(12);
        assertFalse(thread.isAlive());
        assertSame(i[0], 10);
    }

}