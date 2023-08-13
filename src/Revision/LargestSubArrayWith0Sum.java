package Revision;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int ans = largestSubArrayWith0Sum(arr);
        System.out.println(ans);
    }

    static int largestSubArrayWith0Sum(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                if (len > maxLen) maxLen = len;
            } else map.put(sum, i);
        }
        return maxLen;
    }
}
