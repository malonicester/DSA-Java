package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappeared {
    public static void main(String[] args) {
        int[] arr = {1, 1};
        List<Integer> ans = findDisappearedNumbers(arr);
        System.out.println(ans);
    }

    static List<Integer> findDisappearedNumbers(int[] arr) {
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
            if (arr[j] != j + 1)
                ans.add(j + 1);
        }
        return ans;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
