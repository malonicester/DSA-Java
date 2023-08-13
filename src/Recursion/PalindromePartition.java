package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePartition {
    public static void main(String[] args) {
//        palindromePartition("aab", "");
        ArrayList<ArrayList<String>> ans = palindromePartition("aab");
        System.out.println(ans);
    }

    static void palindromePartition(String str, String asf) {
        if (str.isEmpty()) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String pal = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (isPalindrome(pal)) {
                palindromePartition(ros, asf + pal + "\t");
            }
        }
    }

    static ArrayList<ArrayList<String>> palindromePartition(String str) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        helper(list, ans, str);
        return list;
    }

    private static void helper(ArrayList<ArrayList<String>> list, ArrayList<String> ans, String str) {
        if (str.isEmpty()) {
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(0, i + 1);
            if (isPalindrome(temp)) {
                ans.add(temp);
                helper(list, ans, str.substring(i + 1));
                ans.remove(ans.size() - 1);
            }
        }
    }


    static boolean isPalindrome(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);
            if (start != end) return false;
        }
        return true;
    }


}
