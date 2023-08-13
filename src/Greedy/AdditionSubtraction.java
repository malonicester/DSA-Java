package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AdditionSubtraction {
    public static void main(String[] args) {
//        Job[] arr = {new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30)};
//        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

    }

    static int additionSubtraction(int[] arr, int k) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                int cost = 0;
                if (arr[j] <= i) {
                    cost = (i - arr[j]) * 3;
                } else {
                    cost = (arr[j] - i) * 5;
                }
                list.add(cost);
            }
            list.sort((a, b) -> a - b);
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += list.get(j);
            }
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
}

