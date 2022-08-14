package demo;
class Test {
    public static void hello() {
        System.out.println("hello");
    }
}
public class MyApplication {
    public static void main(String[] args) {
        byte x = 1;
        byte y = (byte) (x+x);
        int a = 5;
//        int b = a++ + ++a;
        int b = ++a + a++;
        System.out.println(b);
        // TODO Auto-generated method stub
        Test test=null;
        test.hello();
    }
}