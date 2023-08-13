package Revision;

// https://leetcode.com/contest/weekly-contest-346/problems/minimum-string-length-after-removing-substrings/
public class MinimumStringLength {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        int ans = minimumStringLengthAfterSubStringRemoval(s);
        System.out.println(ans);
    }

    static int minimumStringLengthAfterSubStringRemoval(String s) {
        int a = 0, b = 0, c = 0, d = 0, n = s.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') a++;
            else if (ch == 'B') b++;
            else if (ch == 'C') c++;
            else if (ch == 'D') d++;
        }
        int AB = Math.min(a, b);
        int CD = Math.min(c, d);
        return n - AB * 2 - CD * 2;
    }
}
