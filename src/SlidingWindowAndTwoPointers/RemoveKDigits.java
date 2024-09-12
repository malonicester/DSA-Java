package SlidingWindowAndTwoPointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public static void main(String[] args) {
    }

    private static String removeKDigits(String str, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (; i < str.length() && k > 0; i++) {
            while (!dq.isEmpty() && k > 0 && dq.peekLast() > str.charAt(i)) {
                k--;
                dq.pollLast();
            }
            dq.offerLast(str.charAt(i));
        }

/*
        If  element is 123456 and k = 2 remove the last elements because they are the greater elements
 */
        while (k > 0){
            k--;
            dq.pollLast();
        }

        boolean isLeadingZero = true;
        while (!dq.isEmpty()) {
            char ch = dq.pollFirst();
            if(isLeadingZero && ch == '0') continue;
            isLeadingZero = false;
            sb.append(ch);
        }
        return sb.toString();
    }
}
