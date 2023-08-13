package DSA421;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {9, 12, 4, 1, 2, -1, 8};
        int ans = firstMissingPositive(arr);
        System.out.println(ans);
    }

    static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean one = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) one = true;
            if (arr[i] > n || arr[i] < 1) {
                arr[i] = 1;
            }
        }
        if (!one) return 1;
        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]);
            arr[idx - 1] = -1 * Math.abs(arr[idx - 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
