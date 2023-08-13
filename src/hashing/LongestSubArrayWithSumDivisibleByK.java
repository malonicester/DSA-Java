package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumDivisibleByK {
    public static void main(String[] args) {
        int[]arr = {-2, 2, -5, 12, -11, -1, 7};
        int ans = longestSubArraySumDivisibleByK(arr,3);
        System.out.println(ans);
    }

    static int longestSubArraySumDivisibleByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int rem = 0;
        int sum = 0;
        int ans = 0;
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            rem = sum % k;
            if(rem<0)rem+=k;
            if (map.containsKey(rem)) {
                ans = Math.max(ans, i - map.get(rem));
            } else {
                map.put(rem, i);
            }
        }
        return ans;
    }
}
