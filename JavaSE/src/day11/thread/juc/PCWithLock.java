package day11.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCWithLock {

    public static void main(String[] args) {
        Date date = new Date();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    date.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Inc1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    date.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Inc2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Dec1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Dec2").start();
    }
}

class Date{
    private int number = 1;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try{
            while(number == 1){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try{
            while(number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }
}
