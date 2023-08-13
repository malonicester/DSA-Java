package DSA421;

import java.util.*;

public class CoinSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(arr, 5);
        System.out.println(ans);
        int ans = fibonaaci(4);
        System.out.println(ans);
    }


    static void print(int[] arr, int val) {
        List<Integer> list = new ArrayList<>();
        getSum(list, arr, 0, 0, val);
    }

    static boolean ans = false;

    private static void getSum(List<Integer> list, int[] arr, int index, int sum, int val) {
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            sum += arr[i];
            if (sum == val) {
                ans = true;
                return;
            }
//            list.add(arr[i]);
            getSum(list, arr, i + 1, sum, val);
            sum -= arr[i];
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static int fibonaaci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int ans = fibonaaci(n - 1) + fibonaaci(n - 2);
        list.add(ans);
        return list.get(ans);
    }
}
