package Important_Questions;

import java.util.*;

public class SignalCapacity {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        signalCapacity(arr);
        Map<Character,Integer> map = new TreeMap<>();
    }

    static void signalCapacity(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                sb.append((i + 1) + " ");
            } else {
                sb.append(i - st.peek() + " ");
            }
            st.push(i);
        }
        System.out.println(sb);
    }
}
