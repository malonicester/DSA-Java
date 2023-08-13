package DP;

public class JumpGame1 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 0, 0};
        boolean[] dp = new boolean[arr.length + 1];
        boolean ans = toTop(arr);
        System.out.println(ans);
    }
//    Solved Using greedy -> Better than dp in this case because of no extra space and less time complexity
//    Similar approach like Next Greater Element
//    Start from n-2 index if it can reach n-1 or not
//    if the change destination to that index and continue like that
//    In the end if We reach the last index we got Yes else No
    static boolean toTop(int[] arr) {
        int index = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] + i >= index) {
                index = i;
            }
        }
        if (index == 0) return true;
        return false;
    }
}
