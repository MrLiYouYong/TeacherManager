package demo;

public class demo1 {
    int x,y;
    demo1(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        demo1 demo1 = new demo1(1,2);
        System.out.println(demo1.x);
        System.out.println(demo1.y);

    }

}
