package day13.pattern;

import org.junit.Test;

public class PatternDemo {
    private static final String SPINRG = "Spring";
    private static final String SUMMER = "Summer";

    @Test
    public void test1() {
        //'Singleton1()' has private access in 'com.situ.day20.pattern.Singleton1'
        // Singleton1 instance1 = new Singleton1();
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1 == instance2);// true

        Singleton2 instance3 = Singleton2.getInstance();
        Singleton2 instance4 = Singleton2.getInstance();
        System.out.println(instance3 == instance4);// true

        Singleton4 singleton4 = Singleton4.INSTANCE;
        System.out.println(singleton4);
    }
}
