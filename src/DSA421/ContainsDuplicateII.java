package DSA421;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean ans = containsDuplicateII(arr, k);
        System.out.println(ans);
    }

    static boolean containsDuplicateII(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (Math.abs(i - map.get(arr[i])) <= k) return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
