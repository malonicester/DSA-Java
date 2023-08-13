package DSA421;

import java.util.ArrayList;
import java.util.List;

public class Tribonacci {
    public static void main(String[] args) {
        long ans = tribonacci(6);
        System.out.println(ans);
    }

    static long[] arr = new long[1000];

    static long tribonacci(long n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (arr[(int) n] != 0) return arr[(int) n];
        arr[(int) n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return arr[(int) n];
    }
}
