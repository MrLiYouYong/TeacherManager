package day13.binSearch;

import java.util.Scanner;

public class binSearch2 {
        public static void main(String[] args) {
            int[] arr = {-56,12,23,23,33,34,74,101};
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int start = 0, end = arr.length-1;
            int result = binSearch(arr,start,end,n);
            if (result == -1){
                System.out.println("数组中没有该数据");
            } else {
                System.out.println(n+"的下标为："+result);
            }
    }

    public static int binSearch(int[] arr, int start, int end, int key){
            int mid = (start+end)/2;
            if(start > end){
                return -1;
            }
            if(arr[mid] > key){
                return binSearch(arr,start,mid-1,key);
            } else if (arr[mid] < key) {
                return binSearch(arr,mid+1,end,key);
            } else {
                return mid;
            }
        }
}
