package Maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayPermutation {
    public static void main(String[] args) {
        System.out.println(countArrangement(1));
    }
    public static int countArrangement(int n) {
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }

        generatePermutationsWithoutSpace(nums,0);
        System.out.println(count);
        return count;
    }
    static List<List<Integer>> permutationOfArray(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        addToList(list, new ArrayList<Integer>(), nums, visited);
        return list;
    }

    private static void addToList(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] visited) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            tempList.add(nums[i]);
            visited[i] = true;
            addToList(list, tempList, nums, visited);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }

    static void printPermutation(int[] arr, String p, boolean[] freq) {
        if (p.length() == arr.length * 2) {
            System.out.println(p.trim() + " ");
        }
        for (int i = 0; i < arr.length; i++) {
            if (freq[i]) continue;
            freq[i] = true;
            printPermutation(arr, p + " " + arr[i], freq);
            freq[i] = false;
        }
    }

    static int count = 0;
    static void generatePermutationsWithoutSpace(int[] arr, int index) {
        if (index == arr.length - 1) {
            if( index != 0 && arr[index]%index==0 || index % arr[index]==0) count++;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            generatePermutationsWithoutSpace(arr, index + 1);
//            Backtracking
            swap(arr, i, index);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
