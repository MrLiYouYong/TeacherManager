package day11.thread.produceconsume;

import java.util.Random;

public class ProducerThread extends Thread{

    private Panzi panzi;
    public ProducerThread(String name, Panzi panzi){
        super(name);
        this.panzi = panzi;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Cake cake = new Cake("no: " + i);
            panzi.putCake(cake);
//            System.out.println(Thread.currentThread().getName()+"生产蛋糕"+cake);

            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
