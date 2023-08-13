package Recursion;

public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {6, 5, 4},
                {2, 1, 1}
        };
        int ans = longestIncreasingPath(arr, 0, 0, 0, 0, 0);
        System.out.println(ans);
    }

    static int longestIncreasingPath(int[][] arr, int m, int n, int prev, int count, int max) {
        if (arr[m][n] <= prev) {
            return count;
        }
        int down = 0;
        int up = 0;
        int right = 0;
        int left = 0;
        if (isValid(arr, m + 1, n, arr[m][n])) {
            down = longestIncreasingPath(arr, m + 1, n, arr[m][n], count + 1, max);
        } else if (isValid(arr, m - 1, n, arr[m][n])) {
            up = longestIncreasingPath(arr, m - 1, n, arr[m][n], count + 1, max);
        } else if (isValid(arr, m, n + 1, arr[m][n])) {
            right = longestIncreasingPath(arr, m, n + 1, arr[m][n], count + 1, max);
        } else if (isValid(arr, m, n - 1, arr[m][n])) {
            left = longestIncreasingPath(arr, m, n - 1, arr[m][n], count + 1, max);
        }
        int val = down+up+right+left;
        if (m < arr.length ) {
            m = m + 1;
        }
        if ( m==arr.length && n < arr[0].length) {
            n = n + 1;
        }
        return Math.max(val,max);
    }

    static boolean isValid(int[][] arr, int m, int n, int prev) {
        if (m < 0 || n < 0 || m >= arr.length || n >= arr[0].length) {
            return false;
        }
        return true;
    }

    static int maximum(int a, int b, int c, int d) {
        int max = Integer.MIN_VALUE;
        int max1 = Math.max(a, b);
        int max2 = Math.max(c, d);
        return Math.max(max1, max2);
    }
}
