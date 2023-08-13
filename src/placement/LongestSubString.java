package placement;

// https://oj.masaischool.com/contest/9459/problem/999
public class LongestSubString {

    public static void main(String[] args) {
        int ans = longestSubsequence("AEDFHR", "ABCDGH", 6, 6);
        System.out.println(ans);
    }

    static int longestSubsequence(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) return 0;

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + longestSubsequence(s1, s2, i - 1, j - 1);
        }
        return Math.max(longestSubsequence(s1, s2, i, j - 1), longestSubsequence(s1, s2, i - 1, j));
    }
}
