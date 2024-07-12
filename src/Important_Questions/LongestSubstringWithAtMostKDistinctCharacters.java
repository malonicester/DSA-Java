package Important_Questions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {

    }

    public static int longestSubStringWithAtMostKDistinctCharacters(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, i = 0, j = 0;

        while (i < str.length() && j < str.length()) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                char c = str.charAt(j);
                int val = map.get(c);
                if (val == 1) map.remove(c);
                else map.put(c, val - 1);
                j++;
            }
            res = Math.max(res, i - j + 1);
            i++;
        }

        return res;
    }
}
