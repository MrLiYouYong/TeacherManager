package day3;

import org.junit.Test;

import java.util.Scanner;

public class test {
    class Number{
        private int num1;
        private int num2;

        public Number(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
//add, subtract, multiply and divide
        public int add(){
            return num1+num2;
        }

        public int subtract(){
            return num1-num2;
        }

        public int multiply(){
            return num1*num2;
        }

        public double divide(){
            return ((double)num1)/((double)num2);
        }
    }

    @Test
    public void test1(){
        int a,b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println("请输入你想要计算加减乘除运算的两个整形值");
        Number number = new Number(a,b);
        int add = number.add();
        int subtract = number.subtract();
        int multiply  = number.multiply();
        double divide = number.divide();

        System.out.println("相加："+add+"\t"+"相减："+subtract+"\t"+"相乘: "+multiply+"\t"+"相除: "+divide);
    }

    class Rectangle{
        private int length;
        private int wide;

        public Rectangle() {
            this.length = 1;
            this.wide = 1;
        }

        public Rectangle(int length) {
            this.length = length;
            this.wide = length;
        }

        public Rectangle(int length, int wide) {
            this.length = length;
            this.wide = wide;
        }
    }

    @Test
    public void test2(){
        Scanner scanner = new Scanner(System.in);
        int length,wide;
        int perimeter,area;

        System.out.println("请输入目标长方形的长：");
        length = scanner.nextInt();
        System.out.println("请输入目标长方形的宽：");
        wide = scanner.nextInt();
        Rectangle rectangle;
        if (length == wide) {
            rectangle = new Rectangle(length);
        }else {
            rectangle = new Rectangle(length,wide);
        }

        perimeter = (rectangle.length+rectangle.wide)*2;
        area = rectangle.length*rectangle.wide;

        System.out.println("目标长方形的周长为："+perimeter);

        System.out.println("目标长方形的面积为："+area);

    }
}
