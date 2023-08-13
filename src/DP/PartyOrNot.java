package DP;

public class PartyOrNot {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int price = 42;
        boolean[][] dp = new boolean[arr.length + 1][price + 1];
        boolean ans = partyOrNot(arr, price, 0,dp);
        System.out.println(ans?"Party":"No Party");
    }

    static boolean partyOrNot(int[] arr, int price, int index, boolean[][] dp) {
        if (index == arr.length) return false;
        if(price==0) return true;
        if (dp[index][price]) return true;
        boolean notTake = partyOrNot(arr, price, index + 1, dp);
        boolean take = false;
        if (arr[index] <= price) {
            take = partyOrNot(arr, price - arr[index], index + 1, dp);
        }
        return dp[index][price] = notTake || take;
    }
}
