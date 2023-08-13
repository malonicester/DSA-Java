package DSA421;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};
        int ans = rainWaterTrapping(arr);
        System.out.println(ans);
    }

    //    Brute Force Approach
    static int trappingRainWater(int[] arr) {
        int water = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int lmax = arr[i];
            int rmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            for (int j = i + 1; j < arr.length; j++) {
                rmax = Math.max(rmax, arr[j]);
            }
            water += Math.min(lmax, rmax) - arr[i];
        }
        return water;
    }

    //    Optimized With Space
    static int rainWaterTrapping(int[] arr) {
        int[] left = new int[arr.length];
        left[0] = arr[0];

        int[] right = new int[arr.length];
        right[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }


        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int water = 0;
        for (int i = 1; i < arr.length; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }
        return water;
    }
}
