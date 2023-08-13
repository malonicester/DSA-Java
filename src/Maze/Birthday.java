package Maze;

import java.util.ArrayList;
import java.util.List;

public class Birthday {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> list = printCombinations(arr, 2);
        System.out.println(list);
    }

    static List<List<Integer>> printCombinations(int[] arr, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        getCombinations(list, ans, arr, index, k);
        return list;
    }

    static void getCombinations(List<List<Integer>> list, List<Integer> ans, int[] arr, int index, int k) {
        if (ans.size() == k) {
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            ans.add(arr[i]);
            getCombinations(list, ans, arr, i + 1, k);
            ans.remove(ans.size() - 1);
        }
    }
}
