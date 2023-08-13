package BinarySearch;

public class Ceiling {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,4,6,7};
        int ans = ceiling(arr,3);
        System.out.println(ans);
    }

    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
