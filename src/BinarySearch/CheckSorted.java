package BinarySearch;

public class CheckSorted {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3};
        int ans = checkSorted(arr);
        System.out.println(ans);
    }

    static int checkSorted(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                start = mid + 1;
            } else if (arr[mid] != arr[mid - 1] || arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else {
                end = mid - 1;
            }
        }
        return arr[start];
    }
}
