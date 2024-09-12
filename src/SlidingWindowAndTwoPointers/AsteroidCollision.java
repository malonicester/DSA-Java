package SlidingWindowAndTwoPointers;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 1, 2};
        int[] ans = collision(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] collision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && !isSameDirection(arr[i], st.peek()) && st.peek() > 0 && arr[i] < 0) {
                if (Math.abs(arr[i]) == Math.abs(st.peek())) {
                    st.pop();
                    arr[i] = 0; // Both objects are destroyed
                } else if (Math.abs(arr[i]) > Math.abs(st.peek())) {
                    st.pop();
                } else {
                    arr[i] = 0; // Incoming object is destroyed
                }
            }
            if (arr[i] != 0) {
                st.push(arr[i]);
            }

        }
        int[] ans = new int[st.size()];
        int index = ans.length - 1;
        while (!st.isEmpty()) {
            ans[index--] = st.pop();
        }
        return ans;
    }

    private static boolean isSameDirection(int i, int j) {
        return (i > 0 && j > 0) || (i < 0 && j < 0);
    }
}
