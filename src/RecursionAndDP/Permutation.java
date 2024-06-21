package RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        permutation(new int[]{1, 2, 3}, 0);
    }

    static List<List<Integer>> permutation(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permutation(arr, list, new ArrayList<>(), new boolean[arr.length]);
        return list;
    }

    private static void permutation(int[] arr, List<List<Integer>> ans, List<Integer> list, boolean[] visited) {
        if (list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                permutation(arr, ans, list, visited);
                visited[i] = false;
                list.removeLast();
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//   The Recursion Tree -> C:\Users\ashis\Downloads\permutatio.png
    public static void permutation(int[] arr, int index) {
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permutation(arr, index + 1);
            swap(arr, i, index);
        }
    }

    public static void stringPermutation(String str) {
        List<String> ans = new ArrayList<>();
        stringPermutation("", str, ans);
        System.out.println(ans);
        System.out.println("No Of Permutation Are: " + ans.size());
    }

    public static void stringPermutation(String processed, String unprocessed, List<String> ans) {
        if (unprocessed.isEmpty()) {
            ans.add(processed);
            return;
        }
/*
        Taking the first item from the unprocessed and
        placing it all possible places of the processed
        because that how you create permutations.

        To do that you have to call the functions at each place of the processed
        at you have to loop over the length of the processed

        like
        processed / unprocessed
        bc / a
        _b_c_
        'a' can come in three places, so we have to go length + 1 places
 */

        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String last = processed.substring(i);
            stringPermutation(first + ch + last, unprocessed.substring(1), ans);
        }
    }

    public static List<String> stringPermutationList(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return List.of(processed);
        }
        char ch = unprocessed.charAt(0);
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String last = processed.substring(i);
            list.addAll(stringPermutationList(first + ch + last, unprocessed.substring(1)));
        }
        return list;
    }
}
