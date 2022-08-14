package day2;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        int month,year;
        boolean isLeapYear = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份");
        year = scanner.nextInt();
        System.out.println("请输入月份");
        month = scanner.nextInt();


        if(month == 2){

        } else if ((year%400 == 0) || (year%100!=0 && year%4==0)) {
            System.out.println("29");
        }

        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){

        }

    }
}
