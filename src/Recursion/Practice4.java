package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice4 {
    public static void main(String[] args) {
//        printKeyPad("", "23");
        List<String> ans = phoneKeyPad("23");
        System.out.println(ans);
    }

    static String[] code = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static void printKeyPad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = 0; i < code[digit].length(); i++) {
            char codeforCh = code[digit].charAt(i);
            printKeyPad(p + codeforCh, up.substring(1));
        }
    }

    static List<String> phoneKeyPad(String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        int digit = up.charAt(0) - '0';
        List<String> rres = phoneKeyPad(up.substring(1));
        List<String> mres = new ArrayList<>();
        for (int i = 0; i < code[digit].length(); i++) {
            char codeforch = code[digit].charAt(i);
            for (String s : rres) {
                mres.add(codeforch+s);
            }
        }
        return mres;
    }
}
