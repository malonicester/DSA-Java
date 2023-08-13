package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeDuplicatesFromSortedArrays {
    public static void main(String[] args) {
        int[]arr = {0,0,1,1,1,2,2,3,3,4};
        int[]ans = removeDuplicates(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] removeDuplicates(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[arr.length-1];
        return arr;
    }
}
