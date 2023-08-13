package placement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratePermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = permutations(arr);
        for(List<Integer> list:ans){
            for(Integer a : list){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> permutations(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        generatePermutation(arr, 0, new boolean[arr.length], new ArrayList<>(), list);
        return list;
    }

    static void generatePermutation(int[] arr, int index, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {

        if (index == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            list.add(arr[i]);
            visited[i] = true;
            generatePermutation(arr, index + 1, visited, list, ans);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }


}
