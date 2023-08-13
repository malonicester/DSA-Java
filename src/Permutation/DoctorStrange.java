package Permutation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DoctorStrange {
    public static void main(String[] args) {
//        print(3, new ArrayList<>(), 1);
        int[] arr = {5 ,1, 6, 1, 2 ,5 ,5};
        Arrays.sort(arr);
        List<List<Integer>> list = removeDuplicates(arr);
        System.out.println(list);
    }

    static void print(int n, List<Integer> list, int index) {
        System.out.println(list);
        if (index == n + 1) {
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            print(n, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    static List<List<Integer>> removeDuplicates(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        generate(list, ans, arr, index);
        return list;
    }

    public static HashMap<List<Integer>, Integer> map = new HashMap<>();

    private static void generate(List<List<Integer>> list, List<Integer> ans, int[] arr, int index) {

        map.put(ans, map.getOrDefault(ans, 0) + 1);
        if (map.get(ans) == 1) {
            list.add(new ArrayList<>(ans));
        }
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            ans.add(arr[i]);
            generate(list, ans, arr, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}
