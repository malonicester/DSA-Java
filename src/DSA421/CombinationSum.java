package DSA421;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = permutation(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        getAsList(arr, target, ans, list, 0);
        return list;
    }

    private static void getAsList(int[] arr, int target, List<Integer> ans, List<List<Integer>> list, int index) {
        if (index == arr.length) {
            if (target == 0) {
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        if (arr[index] <= target) {
            ans.add(arr[index]);
            getAsList(arr, target - arr[index], ans, list, index);
            ans.remove(ans.size() - 1);
        }
        getAsList(arr, target, ans, list, index + 1);
    }

    static List<List<Integer>> permutation(int[] arr) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        getPermutations(list, 0, arr);
        return list;
    }

    private static void getPermutations(List<List<Integer>> list, int index, int[] arr) {
        if (index == arr.length) {
            List<Integer> ans = new LinkedList<>();
            for (int i = 0; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            list.add(new LinkedList<>(ans));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            getPermutations(list, index + 1, arr);
            swap(arr, i, index);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
