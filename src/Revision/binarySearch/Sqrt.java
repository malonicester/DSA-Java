package Revision.binarySearch;

public class Sqrt {
    public static void main(String[] args) {
        long ans = squareRoot(37);
        System.out.println(ans);
    }

    static long squareRoot(int n) {
        long start = 0;
        long end = n;
        long ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
