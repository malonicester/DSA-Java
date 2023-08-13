package Maze;

import java.util.ArrayList;
import java.util.List;


public class Practice {
    public static void main(String[] args) {
        printStringPermutations("", "abc");
        System.out.println();
        int[] arr = {2,3,5};
        List<List<Integer>> ans = permutationArray(arr);
        List<List<Integer>> ans1 = subsetArray(arr);
        List<List<Integer>> ans2 = combinationSum(arr,8);
        System.out.println(ans2);
    }

    static void printStringPermutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            printStringPermutations(f + ch + s, up.substring(1));
        }
    }

    static List<List<Integer>> permutationArray(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        getPermutations(list, ans, arr, freq, 0);
        return list;
    }

    private static void getPermutations(List<List<Integer>> list, List<Integer> ans, int[] arr, boolean[] freq, int index) {
        if (ans.size() == arr.length) {
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (freq[i]) continue;
            freq[i] = true;
            ans.add(arr[i]);
            getPermutations(list, ans, arr, freq, index);
            freq[i] = false;
            ans.remove(ans.size() - 1);
        }
    }
    static List<List<Integer>> subsetArray(int[]nums){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        getSubsets(list,ans,nums,index);
        return list;
    }

    private static void getSubsets(List<List<Integer>> list, List<Integer> ans, int[] nums, int index) {
        list.add(new ArrayList<>(ans));
        for (int i = index; i < nums.length ; i++) {
            ans.add(nums[i]);
            getSubsets(list,ans,nums,i+1);
            ans.remove(ans.size()-1);
        }
    }
    static List<List<Integer>> combinationSum(int[]nums,int target){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        getCombinations(list,ans,nums,index,target);
        return list;
    }

    private static void getCombinations(List<List<Integer>> list, List<Integer> ans, int[] nums, int index,int target) {
        if(index==nums.length){
            if(target==0){
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        if(nums[index]<=target){
            ans.add(nums[index]);
            getCombinations(list,ans,nums,index,target-nums[index]);
            ans.remove(ans.size()-1);
        }
        getCombinations(list,ans,nums,index+1,target);
    }
}
