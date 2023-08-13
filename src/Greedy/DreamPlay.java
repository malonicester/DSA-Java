package Greedy;

import java.util.Arrays;
import java.util.Stack;

public class DreamPlay {
    public static void main(String[] args) {
        System.out.println(lexicoGraphicSmallest("gsbab"));
    }

    static String lexicoGraphicSmallest(String s) {
        int[] stuff = new int[s.length() + 1];
        stuff[s.length()] = Integer.MAX_VALUE;
        for (int i = s.length() - 1; i >= 0; i--) {
            stuff[i] = Math.min(stuff[i + 1], s.charAt(i));
        }
        System.out.println(Arrays.toString(stuff));
        Stack<Character> X = new Stack<>();
        StringBuilder Y = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!X.isEmpty() && stuff[i] >= X.peek()) {
                Y.append(X.peek());
                X.pop();
                i--;
            } else if (stuff[i] == s.charAt(i)) {
                Y.append(s.charAt(i));
            } else {
                X.push(s.charAt(i));
            }
        }
        while (X.size() > 0) {
            Y.append(X.pop());
        }
        return Y.toString();
    }
}
