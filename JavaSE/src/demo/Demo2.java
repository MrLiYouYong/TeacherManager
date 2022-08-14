package demo;

public class Demo2 {

    public static int f(int n){
        if(n == 1 || n == 2)
            return n;
        else {
            return f(n-1) + f(n-2);
        }
    }
    public static void main(String[] args) {
        int n = 11;
        System.out.println(f(n));
    }
}
