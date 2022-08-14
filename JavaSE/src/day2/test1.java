package day2;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class test1 {

    @Test
    public void test1(){
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            if(i<5){
                System.out.println();
            }
        }
    }


    @Test
    public void test2(){
        for (int i = 1; i <= 6; i++) {

            for (int k = 5; k >= i; k--){
                System.out.print(" ");
            }
            for (int j = 1; j <= i*2-1; j++) {
                System.out.print("*");
            }
            if(i<6){
                System.out.println();
            }
        }
    }

    @Test
    public void test3(){
        for (int i = 6; i >= 1; i--) {

            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i*2-1; k++) {
                System.out.print("*");
            }
            if(i>1){
                System.out.println();
            }

        }
    }

    @Test
    public void test4(){
        int add_odd=0, add_even=0;
        for (int i = 1; i <= 100; i++) {
            if(i%2==0){
                add_even+=i;
            }
            if(i%2!=0){
                add_odd+=i;
            }
        }
        System.out.println("1~100之间所有奇数之和为："+add_odd+"  所有偶数之和为："+add_even);
    }

    @Test
    public void test5(){
        int isLessThan3 = 1;
        for (int i = 1; i <= 1000; i++) {
            if (i % 5 == 0){
                if(isLessThan3 < 3){
                    isLessThan3++;
                    System.out.print(i+"\t");
                }else{
                    isLessThan3=1;
                    System.out.println(i);
                }
            }
        }
    }

    @Test
    public void test6(){
        int sum = 1;
        for (int i = 1; i <= 9; i++) {
            sum *= i;
        }
        System.out.println(sum);
    }

    @Test
    public void test7(){
        boolean isSuShu = true;
        for (int i = 100; i <= 200; i++) {
            isSuShu = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isSuShu = false;
                    break;
                }
            }
            if(isSuShu){
                System.out.println(i);
            }
        }
    }




}
