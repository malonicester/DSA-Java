package RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class SubsetsAndSubsequence {
    public static void main(String[] args) {
        List<String> val = subsequence("abc", "");
        System.out.println(val);
    }

    public static void subseq(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        subseq(str.substring(1), ans);
        subseq(str.substring(1), ans + str.charAt(0));
    }

    public static List<String> subsequence(String str, String ans) {
        if (str.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        List<String> skip = subsequence(str.substring(1), ans);
        List<String> pick = subsequence(str.substring(1), ans + str.charAt(0));
        pick.addAll(skip);
        return pick;
    }
}
