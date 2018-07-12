package io.eelo.spot.threadPool;

class Waiter extends InfiniteLoop {

    @Override
    public void loop() throws InterruptedException {
        ThreadPool.tasks.take().run();
    }
}
