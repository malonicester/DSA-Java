package Revision;

import java.util.HashMap;
import java.util.Map;

public class SubStrings {
    public static void main(String[] args) {
        getAllSubStrings("pwwkew");
    }

    static void getAllSubStrings(String s) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int ans = longest(s,i,j);
                max = Math.max(ans,max);
            }
        }
        System.out.println(max);
    }

    static int longest(String s, int i, int j) {
        Map<Character, Integer> map = new HashMap<>();
        for (int index = i; index <= j; index++) {
            char ch = s.charAt(index);
            if(map.containsKey(ch)) return 0;
            map.put(ch,1);
        }
        return map.size();
    }
}
