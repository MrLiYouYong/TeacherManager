package day13.binSearch;

import java.util.Scanner;

public class binSearch1 {
    public static void main(String[] args) {
        int[] arr = {-56,12,23,23,33,34,74,101};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = binSearch(arr,n);
        if (result == -1){
            System.out.println("数组中没有该数据");
        } else {
            System.out.println(n+"的下标为："+result);
        }
    }

    static int binSearch(int[] arr, int key){
        int start = 0;
        int end = arr.length-1;
        int mid;

        while(end >= start){
            mid = (end-start)/2+start;

            if(key > arr[mid]){
                start = mid + 1;
            } else if(key < arr[mid]){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
