package Maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class subSeq {
    public static void main(String[] args) {
        ArrayList<String> list = printSubseq("abcd");
        System.out.println(list);
        StringBuilder sb = new StringBuilder("abcd");
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
        HashMap<Character,Integer> map = new HashMap<>();
        System.out.println("abc".contains("bc"));
    }

    static ArrayList<String> subseq(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> right = subseq(p, up.substring(1));
        ArrayList<String> left = subseq(p + ch, up.substring(1));
        left.addAll(right);
        return left;
    }

    static ArrayList<String> printSubseq(String str) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> rres = printSubseq(str.substring(1));
        ArrayList<String> mres = new ArrayList<>();

        for(String s : rres){
            mres.add(ch+s);
            mres.add("" + s);
        }
        return mres;
    }

}
