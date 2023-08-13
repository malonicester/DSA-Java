package Revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertAndMaximize {
    public static void main(String[] args) {
        String s = "96487997989";
        String ans = insertAndMaximize(s, 3);
        System.out.println("ans = " + ans);
    }

    static int jumpingOnTheClouds(List<Integer> list) {
        int i = 0;
        int jumps = 0;
        while (i < list.size()) {
            if (i + 2 < list.size() && list.get(i + 2) == 0) {
                i = i + 2;
            } else i = i + 1;
            jumps++;
        }
        return jumps;
    }

    static int smallestSubStringWithMaxDistinctCharacters(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxChars = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        maxChars = map.size();
        map.clear();
        i = 0;
        j = 0;
        while (i < n && j < n) {
            if (map.size() < maxChars) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (map.size() == maxChars) {
                minLength = Math.min(minLength, j - i + 1);
                if (map.containsKey(s.charAt(i))) {
                    if (map.get(s.charAt(i)) == 1) map.remove(s.charAt(i));
                    else map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    i++;
                }
            } else {
                j++;
            }
        }
        return minLength;
    }

    static String insertAndMaximize(String s, int k) {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while ((i < n) && (k <= ((int) s.charAt(i) - '0'))) {
            sb.append(s.charAt(i));
            i++;
        }
        sb.append(k);
        while (i < n) {
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
