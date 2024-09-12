package Heap.practice;

public class HeightOfHeap {

    private static int heightOfHeap(int[] arr) {
        int n = arr.length, height = 0;
        if (n == 1) return 1;
        while (n / 2 > 1) {
            height++;
            n /= 2;
        }
        return height;
    }
}
