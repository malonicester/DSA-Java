package Important_Questions;

import java.util.*;

public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println(countDistinct(arr, k));
    }

    public static ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k - 1) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            } else {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                list.add(map.size());
                if (map.containsKey(arr[i - k + 1])) {
                    int val = map.get(arr[i - k + 1]);
                    if (val == 1) map.remove(arr[i - k + 1]);
                    else map.put(arr[i - k + 1], val - 1);

                }
            }
        }
        return list;
    }
}
