package placement;

import java.util.HashMap;
import java.util.Map;

public class Happy {
    public static void main(String[] args) {
        String s = "happyhpa";
        int ans = countOccurrence(s);
        System.out.println(ans);
    }

    static int countOccurrence(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 4; i++) {
            if (isPresent(i, i + 4, s)) {
                count++;
            }
        }
        return count;
    }

    static boolean isPresent(int start, int end, String str) {
        Map<Character, Integer> map = new HashMap<>();
        String s = "happy";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = start; i <= end; i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) map.remove(ch);
                else map.put(ch, map.get(ch) - 1);
            } else return false;
        }
        return true;
    }
}
