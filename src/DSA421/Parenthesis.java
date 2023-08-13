package DSA421;

import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        String str = "[one [two [three [four [five [six [seven [eight [nine [ten ]]]]]]]]]]";
        boolean ans = parenthesis(str);
        System.out.println(ans?"balanced":"unbalanced");    }

    static boolean parenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                st.push(ch);
            } else {
                if (ch == ')') {
                    if (st.isEmpty()) {
                        return false;
                    } else if (st.peek() == '(') {
                        st.pop();
                    } else st.push(ch);
                } else if (ch == '}') {
                    if (st.isEmpty()) {
                        return false;
                    } else if (st.peek() == '{') {
                        st.pop();
                    } else st.push(ch);
                } else if (ch == ']') {
                    if (st.isEmpty()) {
                        return false;
                    } else if (st.peek() == '[') {
                        st.pop();
                    } else st.push(ch);
                }
            }
        }
        return st.size() == 0;
    }

}
