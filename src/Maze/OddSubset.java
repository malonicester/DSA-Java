package Maze;

import java.util.ArrayList;
import java.util.List;

public class OddSubset {
    public static void main(String[] args) {
        int[] arr = {-3, -1, -10, 8, -5, 0, 7};
        generateSubeq(new ArrayList<>(), arr, 0, 0);
        System.out.println(count);
    }

    static int count = 0;

    static void generateSubeq(List<Integer> ans, int[] arr, int index, int sum) {
        if (sum % 2 != 0) {
            count++;
        }
        if (index == arr.length) return;
        for (int i = index; i < arr.length; i++) {
            sum += arr[i];
            ans.add(arr[i]);
            generateSubeq(ans, arr, i + 1, sum);
            sum -= ans.get(ans.size() - 1);
            ans.remove(ans.size() - 1);
        }
    }
}
