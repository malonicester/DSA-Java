package Important_Questions;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty()) return false;
                else if (ch == ')' && st.peek() == '(') {
                    st.pop();
                } else if (ch == '}' && st.peek() == '{') {
                    st.pop();
                } else if (ch == ']' && st.peek() == '[') {
                    st.pop();
                }
                else return false;
            }else
                st.push(ch);
        }
        return st.isEmpty();
    }

}
