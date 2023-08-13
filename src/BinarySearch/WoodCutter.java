package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class WoodCutter {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int ans = height(arr, 8);
        System.out.println(ans);
        List<Integer> list = new ArrayList<>();
    }

    static int height(int[] arr, int woodCount) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int wood = 0;
        int start = 0;
        int end = max;
        int mid = 0;
        while (start <= end) {
            wood = 0;
            mid = start + (end - start) / 2;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    wood += arr[i] - mid;
                }
            }
            if (wood == woodCount || start == mid) {
                return mid;
            }
            if (wood > woodCount) {
                start = mid;
            } else {
                end = mid ;
            }

        }
        return -1;
    }
}
