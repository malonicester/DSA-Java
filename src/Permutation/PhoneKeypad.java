package Permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneKeypad {
    public static void main(String[] args) {
        phoneKeypad("23", "");
        subseq("abc", new ArrayList<>(), 0);
        System.out.println(ans);
    }

    static String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> list = new LinkedList<>();

    static void phoneKeypad(String s, String code) {
        if (s.isEmpty()) {
            list.add(code);
            return;
        }
        int index = s.charAt(0) - '0';
        for (int i = 0; i < phone[index].length(); i++) {
            char codeforch = phone[index].charAt(i);
            phoneKeypad(s.substring(1), code + codeforch);
        }
    }

    static List<String> ans = new ArrayList<>();

    static void subseq(String s, List<Character> list, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        ans.add(sb.toString());
        if (index == s.length()) return;
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            list.add(ch);
            subseq(s, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
