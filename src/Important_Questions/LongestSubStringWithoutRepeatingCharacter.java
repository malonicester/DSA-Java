package Important_Questions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int ans = longestSubStringWithoutRepeatingCharacter(str);
        System.out.println(ans);
    }

    static int longestSubStringWithoutRepeatingCharacter(String str) {
        int res = Integer.MIN_VALUE, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                if (index >= j) {
                    j = index + 1;
                }
            }
            res = Math.max(res, i - j + 1);
            map.put(ch, i);
        }
        return res;
    }
}
