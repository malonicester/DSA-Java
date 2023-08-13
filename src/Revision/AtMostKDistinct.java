package Revision;

import java.util.*;

public class AtMostKDistinct {
    public static void main(String[] args) {
        String s = "aabcbcdbca";
        int ans = atMostKDistinctChars(s);
        System.out.println(ans);
    }

    static int atMostKDistinctChars(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int k = map.size();
        map.clear();
        int maxLen = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() == k) {
                char c = str.charAt(j);
                if (map.get(c) == 1) map.remove(c);
                else map.put(c, map.get(c) - 1);
                maxLen = Math.min(maxLen,i - j + 1);
                j++;
            }
        }
        return maxLen;
    }
}
