package Maze;

import java.util.ArrayList;
import java.util.List;

public class SubsetArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = permutationArray(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> subsetArray(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(list, ans, arr, 0);
        return list;
    }

    private static void helper(List<List<Integer>> list, List<Integer> ans, int[] arr, int index) {
        list.add(new ArrayList<>(ans));
        for (int i = index; i < arr.length; i++) {
            ans.add(arr[i]);
            helper(list, ans, arr, i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    static List<List<Integer>> permutationArray(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        getPermutation(list, temp, nums, freq);
        return list;
    }

    private static void getPermutation(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] freq) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (freq[i]) continue;
            freq[i] = true;
            temp.add(nums[i]);
            getPermutation(list, temp, nums, freq);
            freq[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}
