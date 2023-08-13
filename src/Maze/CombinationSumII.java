package Maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,5};
        int k = 5;
        Arrays.sort(arr);
        List<List<Integer>> ans = combinationSum2(arr, k);
        System.out.println(ans);
    }


    static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        generateCombinations(list, ans, 0, target, arr);
        return list;
    }

    static void generateCombinations(List<List<Integer>> list, List<Integer> ans, int index, int target, int[] arr) {
        if (target == 0) {
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            ans.add(arr[i]);
            generateCombinations(list, ans, i + 1, target - arr[i], arr);
            ans.remove(ans.size() - 1);
        }
    }
}
