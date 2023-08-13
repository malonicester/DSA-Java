package Important_Questions;

import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        boolean ans = anagram("nag a ram", "anagram");
        System.out.println(ans);
        int a = 10;
        int b = a--;
        System.out.println(a+" "+b);
    }

    static boolean anagram(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }
        return map.isEmpty();
    }
}
