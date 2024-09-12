package SlidingWindowAndTwoPointers;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {

    }

    private static int removeDuplicatesFromSortedArray(int[] arr) {
        int i = 0, j = 1, currentElement = arr[0], currentElementCount = 1;
        while (j < arr.length) {
            if (arr[j] == currentElement) currentElementCount++;
            if (arr[j - 1] != arr[j]) {
                arr[i++] = arr[j - 1];
                if (currentElementCount >= 2) {
                    arr[i++] = arr[j - 1];
                }
            }
            if (arr[j] != currentElement) {
                currentElement = arr[j];
                currentElementCount = 1;
            }
            j++;
        }
        arr[i++] = arr[arr.length - 1];
        if (currentElementCount >= 2) {
            arr[i++] = arr[arr.length - 1];
        }
        return i;
    }
}
