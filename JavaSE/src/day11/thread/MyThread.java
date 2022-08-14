package day11.thread;

public class MyThread extends Thread{
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName());
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i);
//        }
//    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();//启动线程
//        myThread.run();//只是调用对象里的一个普通run()方法
        System.out.println(Thread.currentThread().getName());
    }
}

//public class MyThread implements Runnable{
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName());
//    }
//
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();
//    }
//}
