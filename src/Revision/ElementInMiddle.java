package Revision;

public class ElementInMiddle {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7};
        int ans = elementInMiddle(arr);
        System.out.println(ans);
    }

    static int elementInMiddle(int[] a) {
        int length = a.length;
        int[] leftMax = new int[length];
        int[] rightMin = new int[length];
        leftMax[0] = a[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], a[i]);
        }

        rightMin[length - 1] = a[length - 1];
        for (int i = length - 2; i > 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        int position = -1;
        for (int i = 1; i < length - 1; i++) {
            if (leftMax[i] <= a[i] && a[i] <= rightMin[i]) {
                position = i;
                break;
            }
        }
        return position;
    }
}
