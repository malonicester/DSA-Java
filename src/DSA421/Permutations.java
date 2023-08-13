package DSA421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generatePermutationsWithoutSpace(arr, 0);
        System.out.println(container);
    }


    static List<List<Integer>> permutations(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        getAllPermutations(arr, 0, new boolean[arr.length], new ArrayList<>(), list);
        return list;
    }

    private static void getAllPermutations(int[] arr, int index, boolean[] track, List<Integer> list, List<List<Integer>> container) {
        if (list.size() == arr.length) {
            container.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (track[i]) continue;
            list.add(arr[i]);
            track[i] = true;
            getAllPermutations(arr, index, track, list, container);
            list.remove(list.size() - 1);
            track[i] = false;
        }
    }

    static List<List<Integer>> container = new ArrayList<>();

    static void generatePermutationsWithoutSpace(int[] arr, int index) {
        if (index == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int a : arr)
                list.add(a);
            container.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            generatePermutationsWithoutSpace(arr, index + 1);
            swap(arr, i, index);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
