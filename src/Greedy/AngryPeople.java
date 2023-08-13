package Greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

public class AngryPeople {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 10};
        int ans = angryPeople(arr);
        System.out.println(ans);
    }

    static int angryPeople(int[] arr) {
        int diff = 0;
        int max = 0;
        Arrays.sort(arr);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                dq.offerFirst(arr[i]);
            } else {
                dq.offerLast(arr[i]);
            }
        }
        for(int i = 0;i<arr.length;i++){
            arr[i] = dq.remove();
        }
       for(int i = 0;i<arr.length-1;i++){
           diff = Math.abs(arr[i]-arr[i+1]);
           max = Math.max(diff,max);
       }
       return max;
    }
}
