package BinarySearch;

public class Upper {
    public static void main(String[] args) {
        int[] arr = {0 ,2, 4, 4, 5, 5, 7, 7 ,9 ,10};
        int ans = upperBound(arr, 3);
        System.out.println(ans);
//        10 3

    }

    static int upperBound(int[] arr, int target) {
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
