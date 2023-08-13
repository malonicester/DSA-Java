package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringRec {
    public static void main(String[] args) {
//        skipCharacter("", "abccdca");
//        String ans = skipAnString("abccappledca");
//        System.out.println(ans);
        subseq("", "abc");
        ArrayList<String> list = subseqArrayList("","abc");
        System.out.println(list);
        int [] arr = {1,2,3};
        List<List<Integer>> ans = subset(arr);
        System.out.println(ans);
    }

    static void skipCharacter(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            skipCharacter(p, up.substring(1));
        } else {
            skipCharacter(p + ch, up.substring(1));
        }
    }

    static String skip1(String str) {
        if (str.isEmpty()) return "";
        char ch = str.charAt(0);
        if (ch == 'a') {
            String ans = skip1(str.substring(1));
            return ans;
        } else {
            String ans = ch + skip1(str.substring(1));
            return ans;
        }
    }

    static String skipAnString(String str) {
        if (str.isEmpty()) return "";
        char ch = str.charAt(0);
        if (str.startsWith("apple")) {
            String ans = skipAnString(str.substring(5));
            return ans;
        } else {
            String ans = ch + skipAnString(str.substring(1));
            return ans;
        }
    }

    //    All the subseq
    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    static ArrayList<String> subseqArrayList(String p, String up) {
        if (up.isEmpty()) {
//            In base condition it will return the object
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
//        Include
        ArrayList<String> left = subseqArrayList(p, up.substring(1));
//        Exclude
        ArrayList<String> right = subseqArrayList(p + ch, up.substring(1));
        left.addAll(right);
        return left;
    }
    static List<List<Integer>> subset(int [] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}
