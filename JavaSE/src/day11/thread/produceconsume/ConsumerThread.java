package day11.thread.produceconsume;

import java.util.Random;

public class ConsumerThread extends Thread{


    private Panzi panzi;

    public ConsumerThread(String name, Panzi panzi){
        super(name);
        this.panzi = panzi;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Cake cake =  panzi.getCake();

//            System.out.println(Thread.currentThread().getName()+"消费"+cake);

            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
