package DSA421;

public class maxSubArraySum {
    public static void main(String[] args) {

    }

    static int maxSubArraySum(int[] arr) {
        int maxSum = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum > 0) sum += arr[i];
            else sum = arr[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

}
