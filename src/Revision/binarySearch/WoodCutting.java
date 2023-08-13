package Revision.binarySearch;

public class WoodCutting {
    public static void main(String[] args) {
        int[] arr = {20, 15, 10, 17};
        int ans = woodCutting(arr, 7);
        System.out.println(ans);
    }

    static int woodCutting(int[] arr, int woodCount) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int wood = 0;
        int start = 0;
        int end = max;
        while (start <= end) {
            wood = 0;
            int mid = start + (end - start) / 2;
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
                end = mid;
            }
        }
        return -1;
    }
}
