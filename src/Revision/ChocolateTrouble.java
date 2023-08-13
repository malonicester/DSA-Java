package Revision;

public class ChocolateTrouble {
    public static void main(String[] args) {
        int ans = chocolateTrouble(10, 10);
        System.out.println(ans);
    }

    static int chocolateTrouble(int n, int m) {
        while (n > 0 && m > 0) {
            if (n < m) {
                m %= n;
            } else {
                n %= m;
            }
        }
        return 2 * (m + n);
    }
}
