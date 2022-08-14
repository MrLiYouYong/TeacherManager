package day11;

public class demo5{
    public static demo5 t1 = new demo5();//静态变里
    //构造块
    {
        System.out.println("blockA");
    }
    //静态块
    static {
    System.out.println("blockB");
    }
    public static void main(String[] args){
        demo5 t2 = new demo5();
    }
}
