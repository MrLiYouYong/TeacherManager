package day11.thread.produceconsume;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallAbleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask,"CallableDemo");//给线程起名字
        thread.start();
        System.out.println(futureTask.get());
    }
}
class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("MyCallable.call"+Thread.currentThread().getName());
        return "abc";
    }
}