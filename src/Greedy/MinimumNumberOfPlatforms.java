package Greedy;

import java.util.Arrays;
import java.util.Map;

public class MinimumNumberOfPlatforms {
    public static void main(String[] args) {
        int[]arriv = {900,940,950,1110,1500,1800};
        int[]dept = {910,1120,1130,1200,1900,2000};
        int ans = minimumPlatforms(arriv,dept);
        System.out.println(ans);
    }

    static int minimumNumberOfPlatforms(int[] arrival, int[] departure) {
        int platforms = 0;
        int maxTrains = 0;
        int i = 0, j = 0;
        Arrays.sort(arrival);
        Arrays.sort(departure);
        while (i < arrival.length && j < departure.length) {
            if (arrival[i] <= departure[j]) {
                maxTrains++;
                i++;
            } else {
                j++;
                maxTrains--;
            }
            platforms = Math.max(platforms, maxTrains);
        }
        return platforms;
    }

    static int minimumPlatforms(int[] arriv, int[] dept) {
        int platforms = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;
        Arrays.sort(arriv);
        Arrays.sort(dept);
        while (i < arriv.length && j < dept.length) {
            if (arriv[i] <= dept[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(platforms, maxPlatforms);
        }
        return maxPlatforms;
    }
}
