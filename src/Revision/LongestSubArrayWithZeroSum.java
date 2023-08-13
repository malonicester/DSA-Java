package Revision;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[]arr = {15,-2,2,-8,1,7,10,23};
        int ans = longestSubArrayWithZeroSum(arr);
        System.out.println(ans);
    }

    static int longestSubArrayWithZeroSum(int[] arr) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }
}
