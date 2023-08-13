package DSA421;

public class Distinct {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] arr2 = {4, 4, 3, 3, 2, 2, 1, 1};
        int ans = countCommon(arr1, arr2, 8);
        System.out.println(ans);
        int[] arr = {7, 4, 2, 8, 1, 3, 6, 5};
        boolean ans1 = subArraySumK(arr, 8);
        System.out.println(ans1);
    }

    static int countCommon(int[] arr1, int[] arr2, int n) {
        int count = 0;
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            if (arr1[i] == arr2[j]) {
                i++;
                j--;
                count++;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

    static boolean subArraySumK(int[] arr, int k) {
        int sum = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr.length) {
            sum += arr[j];
            if (sum > k) {
                sum -= arr[i];
                i++;
            } else {
                j++;
            }
            if (sum == k) return true;
        }
        return false;
    }
}
