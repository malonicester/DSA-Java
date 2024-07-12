package Important_Questions;

import java.util.HashMap;
import java.util.Map;

public class PairDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 7;
        boolean ans = pairDivisibleByK(arr, k);
        System.out.println(ans);

    }

    public static boolean pairDivisibleByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            if (rem < 0) rem += k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            if (key == 0) {
                if (m.getValue() % 2 == 1) return false;
                /**
                 * Here it is taken 2 * key == k
                 * let k = 7 -> 7 / 2 => 3
                 * But There is value 3,4 makes it 7
                 * But as it 3 == 3 (7/2) it will be treated as k / 2, and it should have even value
                 * but 3,4 also makes 7 and make the required condition
                 * So for odd number division by 2 can give incorrect value
                 */
            } else if (2 * key == k) {
                if (m.getValue() % 2 == 1) return false;
            } else {
                int ans = map.getOrDefault(k - key, 0);
                if (ans != m.getValue()) return false;
            }

        }
        return true;
    }
}
