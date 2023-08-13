package Revision;

public class BeautifulPermutations {
    public static void main(String[] args) {
        int n = 2;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        beautifulPermutation(arr, 1,new boolean[n+1]);
        System.out.println(count);
    }

    static int count = 0;

    static void beautifulPermutation(int[] arr, int index,boolean[]visited) {
        if (index == arr.length) {
            count++;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            if (arr[index] % index == 0 || index % arr[index] == 0) {
                beautifulPermutation(arr, index + 1,visited);
            }
            swap(arr, i, index);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
