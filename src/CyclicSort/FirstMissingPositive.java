package CyclicSort;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1,2,0};
        int ans = firstMissingPositive(arr);
        System.out.println(ans);
    }

    static int firstMissingPositive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int index = arr[i] - 1;
            if (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[index]) {
                swap(arr, i, index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                return j + 1;
            }
        }
        return arr.length + 1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
