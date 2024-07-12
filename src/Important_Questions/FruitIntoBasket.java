package Important_Questions;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public static void main(String[] args) {

    }

    public static int fruitIntoBasket(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;
        while (i < arr.length && j < arr.length) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (map.size() > 2) {
                int val = map.get(arr[j]);
                if (val == 1) map.remove(arr[j]);
                else map.put(arr[j], val - 1);
                j++;
            }
            res = Math.max(res, i - j + 1);
            i++;
        }
        return res;
    }
}
