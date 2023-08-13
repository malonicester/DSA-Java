package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "abceabcbb";
        int ans = longestIncreasingWithoutCharacters(s);
        System.out.println(ans);
    }

    static int longestIncreasingWithoutCharacters(String str) {
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
