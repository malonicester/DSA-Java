package Important_Questions;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int ans = maximumConsecutiveOnes(arr, 2);
        System.out.println(ans);
    }

    public static int maximumConsecutiveOnes(int[] arr, int k) {
        int maxLen = 0;
        int i = 0, j = 0, zeroCount = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] == 0) zeroCount++;
            while (zeroCount > k) {
                if (arr[j] == 0) {
                    zeroCount--;
                }
                j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
            i++;
        }
        return maxLen;
    }
}
