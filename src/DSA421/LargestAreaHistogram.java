package DSA421;

import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int ans = largestAreaHistogram(arr);
        System.out.println(ans);
    }

    static int largestAreaHistogram(int[] arr) {
        int maxArea = 1;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int[] ls = new int[arr.length];
        int[] rs = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st1.isEmpty() && arr[i] <= arr[st1.peek()]) {
                st1.pop();
            }
            if (st1.isEmpty()) {
                rs[i] = arr.length;
            } else {
                rs[i] = st1.peek();
            }
            st1.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            while (!st2.isEmpty() && arr[i] <= arr[st2.peek()]) {
                st2.pop();
            }
            if (st2.isEmpty()) {
                ls[i] = -1;
            } else {
                ls[i] = st2.peek();
            }
            st2.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i] * (rs[i] - ls[i] - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
