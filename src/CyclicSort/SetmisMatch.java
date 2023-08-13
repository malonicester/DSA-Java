package CyclicSort;

import java.util.Arrays;

public class SetmisMatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4};
        int[] ans = setMisMatch(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] setMisMatch(int[] arr) {
        int[] ans = new int[2];
        int i = 0;
        while (i < arr.length) {
            int index = arr[i] - 1;
            if (arr[i] != arr[index]) {
                swap(arr, i, index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                ans[1] = arr[j];
                ans[0] = j + 1;
            }
        }
        return ans;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
