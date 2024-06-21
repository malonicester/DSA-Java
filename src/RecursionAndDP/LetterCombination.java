package RecursionAndDP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        List<String> list = letterCombination("2344");
        System.out.println(list);
    }

    private static final String[] LETTERS = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static List<String> letterCombination(String str) {
        if (str == null || str.isEmpty()) return Collections.emptyList();
        List<String> list = new ArrayList<>();
        letterCombinationHelper(str, new StringBuilder(), str.length(), list);
        return list;
    }

    private static void letterCombinationHelper(String str, StringBuilder ans, int length, List<String> list) {
        if (str.isEmpty()) {
            list.add(ans.toString());
            return;
        }
        int index = str.charAt(0) - '0';
        for (int i = 0; i < LETTERS[index].length(); i++) {
            ans.append(LETTERS[index].charAt(i));
            letterCombinationHelper(str.substring(1), ans, length, list);
            ans.deleteCharAt(ans.length() - 1);
        }
    }

    private static List<String> letterCombinationArrayList(String str, StringBuilder ans) {
        if (str.isEmpty()) {
            return List.of(ans.toString());
        }
        List<String> list = new ArrayList<>();
        int index = str.charAt(0) - '0';
        for (int i = 0; i < LETTERS[index].length(); i++) {
            ans.append(LETTERS[index].charAt(i));
            list.addAll(letterCombinationArrayList(str.substring(1), ans));
            ans.deleteCharAt(ans.length() - 1);
        }
        return list;
    }
}
