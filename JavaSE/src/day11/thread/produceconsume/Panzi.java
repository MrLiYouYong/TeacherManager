package day11.thread.produceconsume;
import java.util.LinkedList;

public class Panzi {
    //头部移出，尾部加入,盘子只有十个
    private  LinkedList<Cake> list = new LinkedList<>();
    public synchronized void putCake(Cake cake){
        if(list.size() >= 2){
            try {
                System.out.println("盘子都有蛋糕！需等待...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        list.addLast(cake);
        System.out.println(Thread.currentThread().getName()+"生产蛋糕"+cake);
        notifyAll();
    }

    public synchronized Cake getCake(){
        if(list.size()<= 0){
            try {
                System.out.println("盘子中没有蛋糕，需等待...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Cake cake = list.removeFirst();
        System.out.println(Thread.currentThread().getName()+"消费"+cake);
        notifyAll();
        return cake;
    }
}
