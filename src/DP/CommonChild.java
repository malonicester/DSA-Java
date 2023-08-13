package DP;

public class CommonChild {
    public static void main(String[] args) {
        String s1 = "AA";
        String s2 = "BB";
        int ans = commonChild(s1, s2, s1.length(), s2.length());
        System.out.println(ans);
    }

    static int commonChild(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) return 0;
        int one = Integer.MIN_VALUE;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            one = 1 + commonChild(s1, s2, n - 1, m - 1);
        }
        int two = commonChild(s1, s2, n - 1, m);
        int three = commonChild(s1, s2, n, m - 1);
        return max(one, two, three);
    }

    static int max(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        max = Math.max(a, max);
        max = Math.max(b, max);
        return Math.max(max, c);
    }
}
