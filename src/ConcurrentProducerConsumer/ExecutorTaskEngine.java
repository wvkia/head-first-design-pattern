package ConcurrentProducerConsumer;

import java.util.concurrent.*;

public class ExecutorTaskEngine<T> {

    private static int THREAD_SIZE = 10;

    /**
     * future模型
     *
     * @return
     */
    public Future<T> getFuture() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<T> future = threadPool.submit(new Callable<T>() {
            @Override
            public T call() throws Exception {
                ExecutorService executorService = Executors.newFixedThreadPool(THREAD_SIZE);
                //闭锁，线程停止计数器
                CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZE);

                T data = null;
                for (int i = 0; i < THREAD_SIZE; i++) {

                    //执行任务接口
                    executorService.execute(null);
                }
                executorService.shutdown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return data;
            }
        });
        return future;
    }
}
