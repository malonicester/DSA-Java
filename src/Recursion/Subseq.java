package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subseq {
    public static void main(String[] args) {
        System.out.println(subSeq("abcd"));
//        System.out.println(ans);
        calc("123", "", 1);
        System.out.println(list);
    }

    static List<String> subSeq(String str) {
        if (str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        String res = str.substring(1);
        List<String> rres = subSeq(res);
        List<String> ans = new ArrayList<>();
        for (String s : rres) {
            ans.add(ch + s);
        }
        for (String s : rres) {
            ans.add("" + s);
        }
        return ans;
    }

    public static ArrayList<String> list = new ArrayList<>();

    static void calc(String ip, String op, int k) {
        if (op.length() == k*2) {
            System.out.println(op.trim());
            return;
        }
        if (ip.isEmpty()) {
            return;
        }
        char ch = ip.charAt(0);
        calc(ip.substring(1), op + " " + ch, k);
        calc(ip.substring(1), op, k);
    }

}
