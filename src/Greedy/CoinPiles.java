package Greedy;

import java.util.Arrays;

public class CoinPiles {
    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 2, 5, 1};
        int ans = coinPiles(arr,3);
        System.out.println(ans);
    }

    static int coinPiles(int[] arr, int k) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int coins = 0;
        while (i < j) {
            if (arr[j] - arr[i] > k) {
                arr[j]--;
                coins++;
            }else{
                j--;
            }
        }
        return coins;
    }
}
