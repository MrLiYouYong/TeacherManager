package day9;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Queue queue1 = new ArrayDeque();
//        MyStack obj = new MyStack();
//        obj.push(1);
//        obj.push(2);
//        int param_2 = obj.pop();
//        int param_3 = obj.top();
//        boolean param_4 = obj.empty();
//        System.out.println(param_2);
//        System.out.println(param_3);
//        System.out.println(param_4);
    }
}


//class MyStack {
//    private int maxSize;
//    private int front;
//    private int rear;
//    private int[] arr;
//    public MyStack() {
//
//        maxSize = 101;
//        front = 0;
//        rear = 0;
//        arr = new int[101];
//
//    }
//
//    public void push(int x) {
//
//        arr[rear] = x;
//        rear = (rear+1)%maxSize;
//    }
//
//    public int pop() {
//
//        int temp = arr[front];
//        front = (front+1)%maxSize;
//        return temp;
//    }
//
//    public int top() {
//
//        return arr[front];
//    }
//
//    public boolean empty() {
//        return rear == front;
//    }
//}
//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        int[] a = new int[nums.length-k+1];
//        int count = 0;
//        Queue queue = new Queue(k);
//
//        for(int i = 0; i < k-1; i++){
//            queue.push(nums[i]);
//        }
//
//        for(int i = k-1; i < nums.length ; i++){//先退然后在加
//            queue.push(nums[i]);
//            a[count++] = queue.pop(k);
//
//        }
//
//        return a;
//
//    }
//
//
//    class Queue{
//        private int maxSize;
//        private int rear;
//        private int front;
//        private int arr[];
//
//
//        public Queue(int k){
//            maxSize = k+1;
//            rear = 0;
//            front = 0;
//            arr = new int[maxSize];
//        }
//
//        public void push(int n){
//
//            arr[rear] = n;
//            rear = (rear+1)%maxSize;
//        }
//
//        public int pop(int k){
//            int max = arr[front];
//            for(int i = front; i < front+k; i++){
//                if(max < arr[i]){
//                    max = arr[i];
//                }
//            }
//
//            front = (front+1)%maxSize;
//            return max;
//        }
//    }
//
//}

//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        if(k==1)  return nums;   //针对特殊情况处理；
//        Deque<Integer> deque=new LinkedList<>();   //使用双端队列保持滑动窗口中的可能的最大值。
//        int res[]=new int[nums.length-k+1];
//        //先处理前k个数据
//        deque.add(nums[0]);
//        for(int i=1;i<k;i++){
//            //每次加入保证元素从大到小排列，维持滑动创空中可能的最大值
//            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
//                deque.removeLast();
//            }
//            deque.add(nums[i]);
//        }
//        res[0]=deque.peekFirst();
//        int j=1;
//        for(int i=k;i<nums.length;j++,i++){
//            //处理因窗口滑动而移除的最大值
//            if(nums[i-k]==deque.peekFirst()) deque.removeFirst();
//
//            //与上面同理
//            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
//                deque.removeLast();
//            }
//            deque.add(nums[i]);
//            res[j]=deque.peekFirst();
//
//
//        }
//        return res;
//    }
//}