package day11;
public class TestObj{

    static TestObj testObj = new TestObj();

    public static void main(String[] args){
        char chr = 127;
        int sum = 200;
        chr += 1;
        sum += chr;
        System.out.println(sum);

    }

}

