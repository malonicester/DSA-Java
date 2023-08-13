package BinarySearch;

public class CeilingAndFloor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 8, 19, 20};
        int ans = floor(arr, 20);
        System.out.println(ans);
    }

    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
//        if(target>arr[arr.length-1]){
//            return arr.length-1;
//        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start >= arr.length ? -1 : start;
    }

    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
