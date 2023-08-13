package Important_Questions;

import java.util.HashMap;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6};
        print(arr);
    }

    static void subArraySumZero(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                System.out.println(map.get(sum) + 1 + " " + i);
            }
            map.put(sum, i);
        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == 0) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
