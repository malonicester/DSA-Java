package DSA421;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypad {
    public static void main(String[] args) {
        List<String> list = phoneKeypadCombinations("23");
        String[] arr = {"ab", "cd"};
        List<String> ans = allPossibleCombinations(arr);
        System.out.println(ans);
        System.out.println(list);
    }

    static String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> phoneKeypadCombinations(String s) {
        List<String> list = new ArrayList<>();
        getCombinations(list, s, "", 0);
        return list;
    }

    private static void getCombinations(List<String> list, String s, String comb, int index) {
        if (s.isEmpty()) {
            list.add(comb);
            return;
        }
        char ch = s.charAt(0);
        int valInPhone = ch - '0';
        for (int i = 0; i < phone[valInPhone].length(); i++) {
            char codeforch = phone[valInPhone].charAt(i);
            getCombinations(list, s.substring(1), comb + codeforch, index + 1);
        }
    }

    public static List<String> allPossibleCombinations(String[] arr) {
        List<String> list = new ArrayList<>();
        getAllPossibleCombinations(list, arr, 0, new StringBuilder());
        return list;
    }

    private static void getAllPossibleCombinations(List<String> list, String[] arr, int index, StringBuilder sb) {
        if (index == arr.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr[index].length(); i++) {
            char ch = arr[index].charAt(i);
            getAllPossibleCombinations(list, arr, index + 1, sb.append(ch));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
