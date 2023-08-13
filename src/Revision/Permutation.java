package Revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<String> list = subSeq("abcd");
        System.out.println(list);
    }

    static void permutation(int[] arr, int i, List<List<Integer>> list) {
        if (i == arr.length) {
            List<Integer> ans = new LinkedList<>();
            for (int in = 0; in < arr.length; in++) {
                ans.add(arr[in]);
            }
            list.add(ans);
            return;
        }
        for (int index = i; index < arr.length; index++) {
            swap(arr, i, index);
            permutation(arr, i + 1, list);
            swap(arr, i, index);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static List<String> subSeq(String s) {
        List<String> list = new ArrayList<>();
        getSubSeq(list, s, 0, new StringBuilder());
        return list;
    }

    private static void getSubSeq(List<String> list, String s, int index, StringBuilder sb) {
        list.add(sb.toString());
        if (index == s.length()) return;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            getSubSeq(list, s, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
