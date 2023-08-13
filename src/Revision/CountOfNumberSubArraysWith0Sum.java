package Revision;

import java.util.HashMap;
import java.util.Map;

public class CountOfNumberSubArraysWith0Sum {
    public static void main(String[] args) {
        boolean ans = aToB(6, 3);
        System.out.println(ans);
    }

    static int countNumberOfSubArrayWithZeroSum(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    static boolean aToB(int n, int target) {
        if (n > target) return false;
        if (n == target) return true;
        boolean one = aToB(n * 2, target);
        boolean two = aToB(n * 10 + 1, target);
        return one || two;
    }

    static int longestStreak(int[][] arr) {
        int maxVal = arr[0][1], id = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            int time_req = arr[i][1] - arr[i - 1][1];
            if (time_req >= maxVal) {
                if (time_req == maxVal) {
                    id = Math.min(id, arr[i][0]);
                } else {
                    maxVal = time_req;
                    id = arr[i][0];
                }
            }
        }
        return id;
    }
}
