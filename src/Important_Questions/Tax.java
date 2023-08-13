package Important_Questions;

public class Tax {
    public static void main(String[] args) {
        double income = 1500000;
        double ans = calculateTax(income);
        System.out.println(ans);
    }
    public static double calculateTax(double income) {
        double s1 = 500000 * 10 / 100;
        double s2 = 1000000 * 20 / 100;
        if (income <= 250000) {
            return 0;
        }
        if (income <= 500000) {
            return income * 10 / 100;
        }
        if (income <= 1000000) {
            double val = income - 500000;
            double tax = s1 + val * 20 / 100;
        }
        if (income < 10000000) {
            double tax = income - 1000000;
            return s1 + s2 + (tax * 30 / 100);
        }
        return 750000;
    }
}
