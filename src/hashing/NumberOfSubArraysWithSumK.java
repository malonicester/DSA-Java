package hashing;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraysWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(numberOfSubArraysHavingSumK(arr, k));
    }

    static int numberOfSubArraysHavingSumK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxAns = 0;
        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum-k)) {
                maxAns += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return maxAns;
    }
}
