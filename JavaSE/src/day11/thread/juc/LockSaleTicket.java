package day11.thread.juc;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSaleTicket {
//    public static void main(String[] args) {
//        Ticket ticket = new Ticket();
//        // 多个线程同时访问同一个资源，把资源放入线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "a").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "b").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "c").start();
//    }
public static void main(String[] args) {
    Ticket ticket = new Ticket();

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            ticket.sale();
        }
    },"a");

    new Thread(new Runnable() {
        @Override
        public void run() {
            ticket.sale();
        }
    },"b");

    new Thread(new Runnable() {
        @Override
        public void run() {
            ticket.sale();
        }
    },"c");
}
}

class Ticket{
    private int ticketNum = 30;
    private Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();

        if(ticketNum > 0){
            System.out.println(Thread.currentThread().getName()+"购买第："+ticketNum-- +"个票");
        }
    }
}
//
//// 资源类
//class Ticket {
//    private int ticketNum = 30;
//    // 1、创建锁
//    private Lock lock = new ReentrantLock();
//    /*lock.lock();
//    try{
//
//    } finally{
//        lock.unclock();
//    }*/
//
//    public void sale() {
//        // 2、加锁
//        lock.lock();
//        try {
//            // 3、access the resource protected by the lock
//            // 业务代码
//            if (ticketNum > 0) {
//                System.out.println(Thread.currentThread().getName() + "购得第 ： " + ticketNum-- + "张票，还剩：" + ticketNum + "张票");
//
//                // 让线程慢下来，增大出错的概率
//                Thread.sleep(10);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            // 4、解锁
//            lock.unlock();
//        }
//    }
//}
