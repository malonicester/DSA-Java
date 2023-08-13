package Greedy;

import java.util.Arrays;

//https://oj.masaischool.com/contest/7858/problem/05
public class LoveOfSamos {
    public static void main(String[] args) {

    }

    static int maximumSamosa(int[] arr, int amount) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= amount) {
                amount -= arr[i];
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
