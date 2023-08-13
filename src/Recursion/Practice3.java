package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Practice3 {
    public static void main(String[] args) {
        List<String> ans = subsetWithDuplicates("", "aab");
        System.out.println(ans);
    }

    private static HashMap<String, Integer> map = new HashMap<>();

    static List<String> subsetWithDuplicates(String p, String up) {
        if (up.isEmpty()) {
            map.put(p, map.getOrDefault(p, 0) + 1);
            List<String> list = new ArrayList<>();
            if (map.get(p) == 1) {
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        List<String> left = subsetWithDuplicates(p + ch, up.substring(1));
        List<String> right = subsetWithDuplicates(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
