package Revision.DynamicProgramming;

public class ToTheTop {
    public static void main(String[] args) {

    }

    static boolean toTheTop(int[] arr) {
        int index = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] + i >= index) {
                index = i;
            }
        }
        return index == 0;
    }
}
