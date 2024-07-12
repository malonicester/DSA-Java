package BinarySearch.practice;

public class FindInMountainArray {
    public static void main(String[] args) {
        int ans = findInMountainArray(new MountainArray() {
            private int[] arr = {1, 2, 3, 5, 3};

            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int length() {
                return arr.length;
            }
        }, 0);
        System.out.println(
                ans
        );
    }

    private static int findInMountainArray(MountainArray mountainArray, int target) {
        int peak = PeakIndexOfMountainArray.peakIndexOfMountainArray(mountainArray);
        int min = binarySearch(mountainArray, 0, peak, target);
        int max = binarySearchReverse(mountainArray, peak + 1, mountainArray.length() - 1, target);

        if (min != Integer.MAX_VALUE) return min;
        if (max != Integer.MAX_VALUE) return max;

        return -1;
    }

    private static int binarySearch(MountainArray mountainArray, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArray.get(mid) == target) return mid;
            if (mountainArray.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int binarySearchReverse(MountainArray mountainArray, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArray.get(mid) == target) return mid;
            if (mountainArray.get(mid) > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}

interface MountainArray {
    public int get(int index);

    public int length();
}
