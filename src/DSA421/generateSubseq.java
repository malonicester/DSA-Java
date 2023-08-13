package DSA421;

import java.util.ArrayList;
import java.util.List;

public class generateSubseq {
    public static void main(String[] args) {
//        generateSubseq("abc", new ArrayList<>(), 0);
        subseq("abc", "");
    }


    static void generateSubseq(String s, List<Character> list, int index) {

        StringBuilder sb = new StringBuilder();
        if (list.size() != 0) {
            for (char c : list) {
                sb.append(c + " ");
            }
            System.out.println(sb.toString());
        }
        if (index == s.length()) return;
        for (int i = index; i < s.length(); i++) {
            list.add(s.charAt(i));
            generateSubseq(s, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    static void subseq(String ques, String ans) {
        if (ques.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        subseq(ques.substring(1), ans + ch);
        subseq(ques.substring(1), ans);
    }
}
