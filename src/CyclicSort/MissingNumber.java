package CyclicSort;


public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 1};
        int ans = missingNumber(arr);
        System.out.println(ans);
    }

    static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int index = arr[i];
            if (arr[i]<arr.length && arr[i] != i) {
                swap(arr, i, index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) return j;
        }
        return arr.length;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
