package Revision;

import java.util.ArrayList;
import java.util.List;

public class StringCombinations {
    public static void main(String[] args) {
        String[]arr = {"ab","cd"};
        List<String> list = shuffleAll(arr);
        System.out.println(list);
    }


    public static List<String> shuffleAll(String[] arr) {
        List<String> list = new ArrayList<>();
        stringCombinations(arr, 0, new StringBuilder(), list);
        return list;
    }

    static void stringCombinations(String[] arr, int idx, StringBuilder sb, List<String> list) {
        if (idx == arr.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr[idx].length(); i++) {
            sb.append(arr[idx].charAt(i));
            stringCombinations(arr, idx + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
