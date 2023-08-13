package Recursion;

public class StairCase {
    public static void main(String[] args) {
        System.out.println(numberOfWays(3));
    }

    static int numberOfWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) return 0;
        int count;
        count = numberOfWays(n - 1) + numberOfWays(n - 2) + numberOfWays(n - 3);
        return count;
    }
}
