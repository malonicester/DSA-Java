package Greedy;

import java.util.Arrays;

//Fractional Knapsack
//https://oj.masaischool.com/contest/7858/problem/02
public class StealAsMuchYouCan {
    public static void main(String[] args) {
        int[] weight = {30, 2, 3};
        int[] values = {10, 20, 3};
        int ans = stealAsMuchYouCan(weight, values, 20);
        System.out.println(ans);
    }

    static int stealAsMuchYouCan(int[] weight, int[] values, double capacity) {
        double[][] arr = new double[weight.length][3];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = (values[i] * 1.0) / weight[i];
            arr[i][1] = values[i];
            arr[i][2] = weight[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] > b[0]) return -1;
            if (a[0] < b[0]) return 1;
            return 0;
        });
        for (double[] a : arr)
            System.out.println(Arrays.toString(a));
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            double value = arr[i][2];
            if (value > capacity) {
                ans += capacity * arr[i][0];
                capacity = 0;
            } else {
                ans += arr[i][1];
                capacity -= arr[i][2];
            }
            if (capacity == 0) {
                return (int) ans;
            }
        }
        return  ans;
    }
}
