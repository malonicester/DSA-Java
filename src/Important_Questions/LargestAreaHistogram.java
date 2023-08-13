package Important_Questions;

import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(maximum(arr));
    }

    static int maximum(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != -1) {
                int area = arr[i] * (ans[i] - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
