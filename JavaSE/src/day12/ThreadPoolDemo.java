package day12;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                7,1, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        try {

            for (int i = 0; i < 10; i++) {
                final int index = i;
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " 为第" + index + "个任务提供服务");
                    }
                });
            }
        }finally {
            threadPool.shutdown();
        }
    }
}
