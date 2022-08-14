package day1;

import org.junit.Test;

import java.util.Scanner;

public class demo {

        @Test
        public void demo(){
            Scanner scanner = new Scanner(System.in);
            double score;
            score = scanner.nextDouble();

            if(score>100 || score<0) {
                return;
            }
            if (score >= 90 && score <= 100) {
                System.out.println("优秀");
            } else if (score >= 80 && score < 90) {
                System.out.println("良好");
            } else if (score >= 70 && score < 80) {
                System.out.println("一般");
            } else if (score >= 60 && score < 70) {
                System.out.println("及格");
            } else {
                System.out.println("不及格");
            }
        }

        @Test
        public void test2(){
            int num1 = 10;
            int num2 = 20;
            System.out.println(num1 > num2 ? num1 : num2);
        }

        public int max(int a, int b){
            return a>b?a:b;
        }
        @Test
        public void test3(){
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = max(a,b);
            System.out.println(result);
        }

    }

