package DP;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        int[][] dp = new int[list.size()][list.size() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[list.get(i).size()];
            Arrays.fill(dp[i], -1);
        }
        for (List<Integer> a : list) {
            System.out.println(a);
        }
    }

    static int triangle(List<List<Integer>> list, int i, int j, int[][] dp) {
        if (i >= list.size() || j >= list.get(i).size()) return Integer.MAX_VALUE / 4;
        if (i == list.size() - 1) return list.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];
        int down = list.get(i).get(j) + triangle(list, i + 1, j + 1, dp);
        int right = list.get(i).get(j) + triangle(list, i + 1, j, dp);
        return dp[i][j] = Math.min(down, right);
    }

}
