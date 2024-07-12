package Important_Questions;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringContainingAllThreeCharacters {
    public static void main(String[] args) {
        String str = "abcabc";
        int ans = numberOfSubstring(str);
        System.out.println(ans);
    }

    public static int numberOfSubstring(String str) {
        int res = 0, n = str.length(), i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>(3);
        while (i < n && j < n) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'a', 'b', 'c' -> map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            while (map.size() == 3) {
                ch = str.charAt(j);
                int val = map.get(ch);
                if (val == 1) map.remove(ch);
                else map.put(ch, val - 1);
                res += n - i;
                j++;
            }
            i++;
        }
        return res;
    }
}
