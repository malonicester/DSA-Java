package Revision;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ans = slidingWindowMaximum(arr, 3);
        System.out.println(Arrays.toString(ans));
    }

    static int[] slidingWindowMaximum(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        int idx = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i >= k - 1) {
                if (dq.isEmpty()) ans[idx++] = -1;
                else ans[idx++] = arr[dq.peek()];
            }
        }
        return ans;
    }
}
