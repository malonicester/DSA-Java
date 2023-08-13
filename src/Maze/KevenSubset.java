package Maze;

import java.util.ArrayList;

public class KevenSubset {
    public static void main(String[] args) {
        int[]arr = {2,3};
        ArrayList<ArrayList<Integer>> list = kEvenSubset(arr,1,0);
        System.out.println(list);
    }

    static ArrayList<ArrayList<Integer>> kEvenSubset(int[] arr, int k, int evenCount) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        generateSubseq(arr, 0, k, evenCount, list, ans);
        return list;
    }

    private static void generateSubseq(int[] arr, int index, int k, int evenCount, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> ans) {
        if (evenCount >= k) {
            list.add(new ArrayList<>(ans));
        }
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] % 2 == 0) evenCount++;
            ans.add(arr[i]);
            generateSubseq(arr, i + 1, k, evenCount, list, ans);
            if (ans.get(ans.size() - 1) % 2 == 0) evenCount--;
            ans.remove(ans.size() - 1);
        }
    }
}
