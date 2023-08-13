package placement;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MarksAndCompetition {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        marksAndCompetition(arr);
    }

    static void marksAndCompetition(int[] arr) {

        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                list.add(arr[i]);
            }

            st.push(arr[i]);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
