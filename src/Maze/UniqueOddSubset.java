package Maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniqueOddSubset {
    public static void main(String[] args) {
        int[] arr = {19, 27, 26 ,27};
        int k = 3;
        uniqueOddSubset(arr, 0, 0, new ArrayList<>(), k, 0);
        System.out.println(count);
    }

    public static int count = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static void uniqueOddSubset(int[] arr, int index, int sum, List<Integer> list, int k, int distCount) {
        if (distCount >= k && sum%2==1) {
            System.out.println(list);
            count++;
        }
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) == 1) distCount++;
            list.add(arr[i]);
            sum += arr[i];
            uniqueOddSubset(arr, i + 1, sum, list, k, distCount);
            int temp = list.get(list.size() - 1);
            sum -= temp;
            if (map.get(temp) == 1) map.remove(temp);
            else map.put(temp, map.get(temp) - 1);
            list.remove(list.size() - 1);
        }
    }
}
