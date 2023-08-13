package DSA421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findAllDisapprearedNumber(arr);
        System.out.println(ans);
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int index = arr[i] - 1;
            if (arr[i] != arr[index])
                swap(arr, i, index);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static List<Integer> findAllDisapprearedNumber(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            int index = arr[i] - 1;
            if (arr[i] <= arr.length && arr[i] != arr[index]) {
                swap(arr, i, index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                ans.add(j + 1);
            }
        }
        return ans;
    }
}
