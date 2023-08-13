package DSA421;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleCombinations {
    public static void main(String[] args) {
        String[] arr = {"ab", "cd"};
        List<String> list = combinations(arr);
        System.out.println(list);
    }

    static List<String> allPossibleCombinations(String[] arr) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getCombinations(arr, list, sb, 0);
        return list;
    }

    private static void getCombinations(String[] arr, List<String> list, StringBuilder sb, int index) {
        if (index == arr.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr[index].length(); i++) {
            sb.append(arr[index].charAt(i));
            getCombinations(arr, list, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    static List<String> combinations(String[] arr) {
        List<String> list = new ArrayList<>();
        int index = 0;
        getAllCombinations(arr, new StringBuilder(), index, list);
        return list;
    }

    private static void getAllCombinations(String[] arr, StringBuilder ans, int index, List<String> list) {
        if (index == arr.length) {
            list.add(ans.toString());
            return;
        }
        for (int i = 0; i < arr[index].length(); i++) {
            char ch = arr[index].charAt(i);
            ans.append(ch);
            getAllCombinations(arr, ans, index + 1, list);
            ans.deleteCharAt(ans.length() - 1);
        }
    }

}
