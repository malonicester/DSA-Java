package RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        palindromePartitioning("abcd");
    }

    public static void palindromePartitioning(String str) {
        List<List<String>> ans = new ArrayList<>();
        palindromePartitioning(str, new ArrayList<>(), ans);
        System.out.println(ans);
    }


    private static void palindromePartitioning(String str, List<String> list, List<List<String>> ans) {
        if (str.isEmpty()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str, 0, i + 1)) {
                list.add(str.substring(0, i + 1));
                palindromePartitioning(str.substring(i + 1), list, ans);
                list.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String str, int i, int j) {
        if (str.isEmpty()) return true;
        for (int k = i; k <= j / 2; k++) {
            char start = str.charAt(k);
            char end = str.charAt(j - 1 - k);
            if (start != end) return false;
        }
        return true;
    }

}
