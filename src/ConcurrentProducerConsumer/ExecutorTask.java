package ConcurrentProducerConsumer;

import java.util.Deque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class ExecutorTask<T> implements Runnable {
    //打印日志
    private static final Logger LOGGER = Logger.getLogger("");
    //毒丸策略
    public static final Object POSISON_PILL = new Object();
    private BlockingQueue<T> blockingQueue;
    private CountDownLatch countDownLatch;
    private TaskInterface taskInterface;
    private AtomicInteger index;
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                try {
                    T data = blockingQueue.take();
                    if (data == POSISON_PILL) {
                        blockingQueue.put(data);
                        break;
                    }
                    //执行具体任务
                    taskInterface.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
