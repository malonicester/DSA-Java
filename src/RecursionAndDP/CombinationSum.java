package RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> list = combinationSumII(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(list);
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new LinkedList<>();
        combinationSum(arr, target, list, new ArrayList<>(), 0);
        return list;
    }

    /*
       the start pointer ensures that all the combination
       are in the order they are in the array.
       else it will repeat the combination lie
        -> [2,3,6,7] original array , target -> 7
       [2,3,3],[3,3,2]

       -> Used i and passed start = i because
       the same number can be included more than once
     */
    private static void combinationSum(int[] arr, int target, List<List<Integer>> list, List<Integer> ans, int start) {
        if (target < 0) return;
        if (target == 0) {
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
            combinationSum(arr, target - arr[i], list, ans, i);
            ans.removeLast();
        }
    }

    public static List<List<Integer>> combinationSumII(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        combinationSumII(arr, target, list, new ArrayList<Integer>(), 0);
        return list;
    }

    private static void combinationSumII(int[] arr, int target, List<List<Integer>> list, List<Integer> ans, int start) {
        if (target < 0) return;
        if (target == 0) {
            list.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i - 1] == arr[i]) continue;
            ans.add(arr[i]);
            combinationSumII(arr, target - arr[i], list, ans, i + 1);
            ans.removeLast();
        }
    }
}
