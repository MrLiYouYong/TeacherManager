package day2;

import java.util.Random;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        System.out.println("猜吧!");
        while(true){
            int random = new Random().nextInt(1000)+1;
            System.out.println(random);
            if (random == guess){
                System.out.println("恭喜你，猜对啦");
                break;
            }else {
                System.out.println(random>guess?"猜大了":"猜小了"+'\n'+"继续猜吧");
            }
        }

    }
}
