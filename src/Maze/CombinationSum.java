package Maze;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8};
        List<List<Integer>> ans = combinationSum(arr, 8);
        System.out.println(ans);
    }

    static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        getCombinations(0, list, ans, nums, target);
        return list;
    }

    private static void getCombinations(int index, List<List<Integer>> list, List<Integer> ans, int[] nums, int target) {
        if (index == nums.length) {
            if (target == 0) {
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        if (nums[index] <= target) {
            ans.add(nums[index]);
//            If element less than or equal to target,reduce target and move to next call
            getCombinations(index, list, ans, nums, target - nums[index]);
            ans.remove(ans.size() - 1);
        }
        //            If element greater than target,reduce target and move ahead
        getCombinations(index + 1, list, ans, nums, target);
    }
}
