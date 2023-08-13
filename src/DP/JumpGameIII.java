package DP;

public class JumpGameIII {
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 1, 2};
        int index = 2;
        int[] visited = new int[arr.length + 1];
        boolean ans = jumpGameIII(arr, index, visited);
        System.out.println(ans);
    }

    static boolean jumpGameIII(int[] arr, int index, int[] visited) {
        if (index < 0 || index >= arr.length) return false;
        if (arr[index] == 0) return true;
        if (visited[index] == 1) return false;
        visited[index] = 1;
        boolean left = jumpGameIII(arr, index - arr[index], visited);
        boolean right = jumpGameIII(arr, index + arr[index], visited);
        return left || right;
    }
}
