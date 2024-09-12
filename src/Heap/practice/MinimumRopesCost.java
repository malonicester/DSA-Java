package Heap.practice;

public class MinimumRopesCost {

    private final int[] arr;
    private int n;

    public MinimumRopesCost(int[] arr) {
        this.arr = arr;
        this.n = arr.length; // Initialize to the full length
        minHeap(arr);
    }

    public int removeElement() {
        if (n == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int element = arr[0];  // Extract the root element (minimum)
        arr[0] = arr[n - 1];  // Replace root with the last element
        n--;  // Reduce heap size
        heapify(arr, n, 0);  // Restore heap property
        return element;
    }

    public void addElement(int element) {
        if (n == arr.length) {
            throw new IllegalStateException("Heap overflow");
        }
        arr[n] = element;  // Add element at the end
        int i = n;
        n++;  // Increase heap size

        // Bubble up to maintain heap property
        while (i > 0 && arr[(i - 1) / 2] > arr[i]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public boolean isEmpty() {
        return n <= 1;  // Check if only one element is left
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        MinimumRopesCost cost = new MinimumRopesCost(arr);
        int sum = 0;

        while (!cost.isEmpty()) {
            int first = cost.removeElement();
            int second = cost.removeElement();
            sum += first + second;
            cost.addElement(first + second);
        }

        System.out.println("Total minimum cost: " + sum);
    }

    private void minHeap(int[] arr) {
        int n = this.n;
        // Build the heap (in-place)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(arr, i, smallest);
            heapify(arr, n, smallest);  // Recursively heapify the affected subtree
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
