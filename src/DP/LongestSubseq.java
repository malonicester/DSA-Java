package DP;

public class LongestSubseq {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int ans = longestSubseq(a, b, a.length(), b.length());
        System.out.println(ans);
    }

    static int longestSubseq(String a, String b, int idx1, int idx2) {
        if (idx1 == 0 || idx2 == 0) return 0;
        if (a.charAt(idx1 - 1) == b.charAt(idx2 - 1)) {
            return 1 + longestSubseq(a, b, idx1 - 1, idx2 - 1);
        }
        return Math.max(longestSubseq(a, b, idx1, idx2 - 1), longestSubseq(a, b, idx1 - 1, idx2));
    }
}
