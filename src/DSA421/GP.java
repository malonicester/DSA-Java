package DSA421;

public class GP {
    public static void main(String[] args) {
        double ans = gp(3, 5);
        System.out.println(Math.round(ans * 10000) / 10000.0);
    }

    static double sum = 0;

    static double gp(int n, int r) {
        if (n == 0) {
            sum += 1;
            return sum;
        }
        double ans = Math.pow(r, n);
        sum += 1 / ans;
        return gp(n - 1, r);
    }
}
