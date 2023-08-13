package Greedy;

import java.util.Arrays;

public class ManageStackBricks {
    public static void main(String[] args) {
        int[] given = {3, 1, 1};
        int[] required = {2, 1, 1};
        int ans = manageStackBricks(given, required, 4, 6);
        System.out.println(ans);
    }

    static int manageStackBricks(int[] given, int[] required, int removeCost, int addCost) {
        int ans = 0;
        Arrays.sort(given);
        Arrays.sort(required);
        for (int i = 0; i < given.length; i++) {
            if (given[i] != required[i]) {
                if (given[i] < required[i]) {
                    ans += Math.abs(given[i] - required[i]) * addCost;
                } else {
                    ans += Math.abs(given[i] - required[i]) * removeCost;
                }
            }
        }
        return ans;
    }
}
