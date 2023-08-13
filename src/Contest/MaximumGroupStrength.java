package Contest;

public class MaximumGroupStrength {
    public static void main(String[] args) {
        int[] arr = {0, -1};
        long ans = maximumGroupStrength(arr, 0, 1);
        System.out.println(ans);
    }

    static long maximumGroupStrength(int[] arr, int index, long ans) {
        if (ans == 0) return 0;
        if (index >= arr.length) return 1;
        long take = arr[index] * maximumGroupStrength(arr, index + 1, arr[index] * ans);
        long notTake = maximumGroupStrength(arr, index + 1, ans);
        return Math.max(take, notTake);
    }
}
