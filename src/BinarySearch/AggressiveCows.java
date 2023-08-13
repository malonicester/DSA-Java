package BinarySearch;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int ans = distance(arr, 3);
        System.out.println(ans);
    }

    static int distance(int[] arr, int cow) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int start = 1;
        int res = 0;
        int end = max - min;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canPlace(arr, cow, mid)) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    static boolean canPlace(int[] arr, int cow, int dist) {
        int count = 1;
        int pos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pos >= dist) {
                count++;
                pos = arr[i];
            }
            if (count == cow) {
                return true;
            }
        }
        return false;
    }
}
