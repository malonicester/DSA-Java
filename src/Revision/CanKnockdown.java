package Revision;

import java.util.Arrays;
import java.util.Map;

public class CanKnockdown {
    public static void main(String[] args) {
        int[] arr = {10,10,10,10};
        knockDown(arr);
    }

    static void knockDown(int[] arr) {
        int count = 0;
        int val = 0;
        int[][] pair = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            pair[i][0] = arr[i];
            pair[i][1] = i + 1;
        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < pair.length; i++) {
            val += Math.abs(pair[i][0] * count + 1);
            count++;
        }
        for (int[] a : pair) {
            System.out.print(a[1]+" ");
        }
        System.out.println("\n"+val);
    }
}
