package Recursion;

import java.util.ArrayList;

public class Practice2 {
    public static void main(String[] args) {
//        int ans = bob(7);
//        System.out.println(ans);
//        ArrayList<String> list = findSubseq("","abc");
//        System.out.println(list);
//        permuatation("", "abc");
//        System.out.println("ab".substring(2));
//        ArrayList<String> ans = permutationArrayList("","abc");
//        System.out.println(ans);
//        String str = "abc";
//        for(int i = 0;i<str.length();i++){
//            System.out.println(str.substring(i,i+1));
//        }
//        System.out.format("%.4f", gp(1, 1));
//        System.out.println(santoshProfit(12));
//        double res = taylorSeries(4, 2);
//        System.out.format("%.4f", res);
//        robot(0, 10, "abcdefghijk");
//        System.out.println(taylorSeries(5, 1465));
//        long n  = 2000000000;
//        reach1(n);
////        450
////        884
////        2000
////        20
    }

    static int stair(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return stair(n - 1) + stair(n - 2) + stair(n - 3);
    }

    static ArrayList<String> findSubseq(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            if (!p.isEmpty()) {
                list.add(p);
            }

            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> right = findSubseq(p + ch, up.substring(1));

        ArrayList<String> left = findSubseq(p, up.substring(1));
        right.addAll(left);
        return right;
    }

    static int bob(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return bob(n - 1) + bob(n - 3) + bob(n - 5);
    }

    public static double sum = 0;

    static double gp(int n, int r) {
        if (n == 0) {
            sum += 1;
            return sum;
        }
        double R = Math.pow(r, n);
        sum += 1 / R;
        return gp(n - 1, r);
    }

    static void permuatation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            permuatation(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationArrayList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans.addAll(permutationArrayList(f + ch + s, up.substring(1)));

        }
        return ans;
    }

    static int santoshProfit(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        return santoshProfit(n - 4) + santoshProfit(n - 8);
    }

    public static double p = 1;
    public static double f = 1;

    static double taylorSeries(int x, int n) {
        double r;
        if (n == 0) {
            return 1;
        }
        r = taylorSeries(x, n - 1);
        f = f * n;
        p = p * x;
        return (r + p / f);
    }

    static void robot(int l, int r, String str) {
        if (l > r) {
            return;
        }
        int mid = l + (r - l) / 2;
        System.out.print(str.charAt(mid));
        robot(l, mid - 1, str);
        robot(mid + 1, r, str);
    }

//    Wrong
//    static void reach1(long n) {
//        if (n == 1) {
//            System.out.println("Yes");
//            return;
//        }
//        if (n <= 0 || n%2!=0 && n%10!=0 && n%20!=0) {
//            System.out.println("No");
//            return;
//        }
//        if (n % 10 == 0) {
//            reach1(n / 10);
//        } else   {
//            reach1(n / 20);
//        }
//
//    }
}