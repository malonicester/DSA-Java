package Maze;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8};
        int[] ans = merge(arr1,arr2);
        System.out.println(Arrays.toString(ans));
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr1.length) {
            if (arr1[i] < arr2[j]) {
                ans[idx++] = arr1[i++];
            } else {
                ans[idx++] = arr2[j++];
            }
        }
        while (j < arr2.length) {
            ans[idx++] = arr2[j++];
        }
        while (i < arr2.length) {
            ans[idx++] = arr1[i++];
        }
        return ans;
    }
}
