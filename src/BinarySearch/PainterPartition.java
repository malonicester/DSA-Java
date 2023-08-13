package BinarySearch;

public class PainterPartition {
    public static void main(String[] args) {
       int[]arr = {1000000, 1000000};
       int ans = painterPartition(arr,1,1000000);
        System.out.println(ans);
        System.out.println(Integer.MAX_VALUE);
    }

    static int painterPartition(int[] arr, int A, int B) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            min = Math.min(arr[i], min);
        }
        int start = min;
        int end = sum;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canPaint(arr, A, B, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (res%10000003)*B;
    }

    private static boolean canPaint(int[] arr, int A, int B, int maxUnit) {
        int unit = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxUnit) return false;
            else if (unit + arr[i] > maxUnit) {
                count++;
                unit = arr[i];
            } else {
                unit += arr[i];
            }
        }
        if (count > A) return false;
        return true;
    }
}

