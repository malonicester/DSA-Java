package Streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AB {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = subSeq(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> subSeq(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        getCombinations(arr, 0, list, new ArrayList<>());
        return list;
    }

    public static Map<List<Integer>, Integer> map = new HashMap<>();

    static void getCombinations(int[] arr, int index, List<List<Integer>> list, List<Integer> ans) {
        map.put(ans, map.getOrDefault(ans, 0) + 1);
        if(map.get(ans)==1) {
            list.add(new ArrayList<>(ans));
        }
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            ans.add(arr[i]);
            getCombinations(arr, i + 1, list, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
