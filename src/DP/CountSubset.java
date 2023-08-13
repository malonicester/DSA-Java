package DP;

import java.util.ArrayList;

public class CountSubset {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4};
        countSubset(arr,5,0,new ArrayList<>());
        System.out.println(count);
    }

    static int count = 0;

    static void countSubset(int[] arr, int sum, int idx, ArrayList<Integer> list) {
        if (idx == arr.length) {
            if (sum == 0) {
                count++;
            }
            return;
        }
        if (arr[idx] <= sum) {
            list.add(arr[idx]);
            countSubset(arr, sum - arr[idx], idx + 1, list);
            list.remove(list.size() - 1);
        }
        countSubset(arr, sum, idx + 1, list);
    }
}
