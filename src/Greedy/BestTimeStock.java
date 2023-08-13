package Greedy;

import java.util.Arrays;

public class BestTimeStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int ams = bestBuy(arr);
        System.out.println(ams);
    }

    static int bestTimeToBuyStockII(int[] prices) {
        int[] profit = new int[prices.length];
        profit[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[i] = prices[i - 1] - prices[i];
        }
        System.out.println(Arrays.toString(profit));
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < 0) {
                ans += Math.abs(prices[i]);
            }
        }
        return ans;
    }

    static int bestBuy(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += (arr[i]-arr[i-1]);
            }
        }
        return profit;
    }

}
