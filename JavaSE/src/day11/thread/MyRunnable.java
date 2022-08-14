package day11.thread;

import org.junit.Test;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abc");
    }
}
