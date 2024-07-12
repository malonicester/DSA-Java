package BinarySearch.practice;

public class CeilingAndFloor {
    public static void main(String[] args) {

    }

    static int binarySearch(int[] arr, int target, boolean val, int n) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
