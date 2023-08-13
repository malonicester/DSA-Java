package Recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class UniqueSubSeq {
    public static void main(String[] args) {
        ArrayList<String> ans = uniqueSubseq("", "aab");
        System.out.println(ans);
    }

    public static HashMap<String, Integer> map = new HashMap<>();

    static ArrayList<String> uniqueSubseq(String p, String up) {
        if (up.isEmpty()) {
            map.put(p, map.getOrDefault(p, 0) + 1);
            ArrayList<String> list = new ArrayList<>();
            if (map.get(p) == 1) {
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> right = uniqueSubseq(p + ch, up.substring(1));
        ArrayList<String> left = uniqueSubseq(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
