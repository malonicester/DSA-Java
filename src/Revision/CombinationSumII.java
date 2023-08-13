package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> ans = combinationSUmII(arr, 8);
        System.out.println(ans);
    }

    static List<List<Integer>> combinationSUmII(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        generateCombinations(arr, target, 0, list, new ArrayList<Integer>());
        return list;
    }

    private static void generateCombinations(int[] arr, int target, int index, List<List<Integer>> list, List<Integer> ans) {
        if (target == 0) {
            list.add(new ArrayList<>(ans));
            return;
        }


        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            ans.add(arr[i]);
            generateCombinations(arr, target - arr[i], i + 1, list, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
