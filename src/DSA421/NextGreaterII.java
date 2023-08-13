package DSA421;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        int[] ans = nextGreaterElementII(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] nextGreaterElementII(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            st.push(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

}
