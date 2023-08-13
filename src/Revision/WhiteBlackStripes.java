package Revision;

public class WhiteBlackStripes {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -2, 1, -2, 4, 1, 9, 3, 9};
        int ans = maxSubArrayOfSizeK(arr,3);
        System.out.println(ans);
    }

    static int blackWhiteStrips(String s, int k) {
        int b = 0, w = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (ch == 'B') b++;
            else if (ch == 'W') w++;
            if (j - i + 1 == k) {
                min = Math.min(min, w);
                if (s.charAt(i) == 'B') b--;
                else w--;
                i++;
            }
        }
        return min;
    }

    static int maxSubArrayOfSizeK(int[] arr, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (i < arr.length && j < arr.length) {
            sum += arr[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
