package Recursion;

import java.util.ArrayList;
import java.util.TreeMap;

public class Dice {
    public static void main(String[] args) {
//        dice("", 4);
//        printCombinations("", "23");
        ArrayList<String> res = subseq("abc");
        System.out.println(res);
        System.out.println(diceArrayList("", 3));
        TreeMap<Integer,Character> tree = new TreeMap<>();
    }


    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> diceArrayList(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            //           same as climbing stairs pattern
            list.addAll(diceArrayList(p + i, target - i));
        }
        return list;
    }

    static String[] code = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static void printCombinations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = 0; i < code[digit].length(); i++) {
            char ch = code[digit].charAt(i);
            printCombinations(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> subseq(String str) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subseq(str.substring(1));
        ArrayList<String> res = new ArrayList<>();
        for (String s : left) {
            res.add("" + s);
            res.add(ch + s);
        }
        return res;
    }
}
