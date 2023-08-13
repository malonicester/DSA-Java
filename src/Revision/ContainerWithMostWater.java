package Revision;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = containerWithMostWater(arr);
        System.out.println(ans);
    }

    static int containerWithMostWater(int[] arr) {
        int n = arr.length, left = 0, right = n - 1, max = 0;
        while (left < right) {
            int w = right - left;
            int h = w * Math.min(arr[left], arr[right]);
            max = Math.max(h, max);
            if (arr[left] < arr[right]) left++;
            else if (arr[left] > arr[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return max;
    }
}
