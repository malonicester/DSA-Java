package Important_Questions;

import java.util.Stack;

public class Allan {
    public static void main(String[] args) {
        allan("dhig#occapi##srww");
    }

    static void allan(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            boolean flag = true;
            if (!st.isEmpty() && st.peek() == '#' && ch != '#') {
                flag = false;
                st.pop();
            }
            if (flag) {
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            char ch = st.pop();
            if (ch != '#')
                System.out.print(ch);
        }
        System.out.println();
    }
}

