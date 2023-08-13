package DSA421;

public class GettingHeated {
    public static void main(String[] args) {
        int[] arr = {30, 25, 35};
        boolean ans = print(arr);
        System.out.println(ans ? "AC" : "No AC");
    }

    static boolean print(int[] arr) {
        if (arr[0] > arr[1] || arr[2] > arr[1]) return false;
        return true;
    }
}
