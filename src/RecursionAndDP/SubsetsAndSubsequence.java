package RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsAndSubsequence {
    public static void main(String[] args) {
        List<String> val = subsequence("abc", "");
        subsetSumII(new int[]{1, 2, 2});
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

    public static void arraySubsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        arraySubsets(arr, 0, list, new ArrayList<>());
        System.out.println(list);
    }

    private static void arraySubsets(int[] arr, int index, List<List<Integer>> list, List<Integer> ans) {
        if (index == arr.length) {
            list.add(new ArrayList<>(ans));
            return;
        }
        arraySubsets(arr, index + 1, list, ans);
        ans.add(arr[index]);
        arraySubsets(arr, index + 1, list, ans);
        ans.removeLast();
    }

    //    This case tha array may contain duplicate elements
//    The solution should not contain any duplicate subsets
    public static void subsetSumII(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        subsetSumII(arr, 0, list, new ArrayList<>());
        System.out.println(list);
    }

    private static void subsetSumII(int[] arr, int index, List<List<Integer>> list, List<Integer> ans) {
        if (index == arr.length) {
            list.add(new ArrayList<>(ans));
            return;
        }
        if (index > 0 && arr[index] != arr[index - 1]) {
            ans.add(arr[index]);
            subsetSumII(arr, index + 1, list, ans);
        }
        subsetSumII(arr, index + 1, list, ans);
    }
}
