package Revision.binarySearch;

public class PaintersPartition {
    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15};
        int ans = paintersPartition(arr, 3);
        System.out.println(ans);
    }

    //    Best case when painters are more than size of array  the max element will be the answer
//    worst case will be when there is only painter then sum of
    static int paintersPartition(int[] arr, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = Math.max(start, arr[i]);
            end += arr[i];
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canPaint(arr, mid, k)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static boolean canPaint(int[] arr, int mid, int k) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                sum = arr[i];
                count++;
            }
        }
        return count <= k;
    }
}
