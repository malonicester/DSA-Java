package RecursionAndDP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum(new int[]{2, 3, 5}, 8);
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
}
