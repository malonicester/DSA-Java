package Revision.DynamicProgramming;

public class MinimumEditDistance {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";
        int ans = minimumEditDistance(s,t,s.length(),t.length());
        System.out.println(ans);
    }

    static int minimumEditDistance(String s, String t, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return minimumEditDistance(s, t, i - 1, j - 1);
        }
        int replace = minimumEditDistance(s, t, i - 1, j - 1);
        int delete = minimumEditDistance(s, t, i - 1, j);
        int add = minimumEditDistance(s, t, i, j - 1);
        return 1 + min(replace, delete, add);
    }

    static int min(int... arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
