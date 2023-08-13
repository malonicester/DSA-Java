package DSA421;

import java.util.HashMap;
import java.util.Map;

public class SubstringMaximum {
    public static void main(String[] args) {

    }

    static void substringWithMaxm(String str) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            m1.put(ch, m1.getOrDefault(ch, 0) + 1);
        }
    }
}
