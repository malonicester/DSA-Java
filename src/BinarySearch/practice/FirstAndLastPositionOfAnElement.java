package BinarySearch.practice;

import java.util.Arrays;

public class FirstAndLastPositionOfAnElement {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 8, 10};
        int[] ans = positionOfFirstAndLastPosition(arr, 8);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] positionOfFirstAndLastPosition(int[] arr, int target) {
        int first = firstPosition(arr, target);
        System.out.println("Calculated");
        int last = lastPosition(arr, target);
        return new int[]{first, last};
    }

    private static int firstPosition(int[] arr, int target) {
        int start = 0, end = arr.length - 1,ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
//                Store the ans because it may be the first
                ans = mid;
            }
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int lastPosition(int[] arr, int target) {
        int start = 0, end = arr.length - 1,ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
//                Store the ans because it may be the last
                ans = mid;
            }
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
