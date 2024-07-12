package BinarySearch.practice;

public class FindPivotInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {8, 9, 10, 11, 0, 1, 2, 3};
        int ans = findPivot(arr);
        System.out.println(ans);
    }

    private static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (start < mid && arr[mid] < arr[start]) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return start;
    }
}
