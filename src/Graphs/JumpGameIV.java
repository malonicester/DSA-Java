package Graphs;

import java.util.*;

public class JumpGameIV {
    public static void main(String[] args) {
        int[] arr = {6, 1, 9};
        int ans = jumpGameIV(arr);
        System.out.println(ans);
    }

    static int jumpGameIV(int[] arr) {
        if (arr.length == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list;
            if (map.containsKey(arr[i])) {
                list = map.get(arr[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(arr[i], list);
            map.get(arr[i]);
        }
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length + 1];
        visited[0] = true;
        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int j = q.remove();
                if (j == arr.length - 1) return steps;
                List<Integer> list = map.get(arr[j]);
                list.add(j - 1);
                list.add(j + 1);
                for (int a : list) {
                    if (a >= 0 && a < arr.length && !visited[a]) {
                        visited[a] = true;
                        q.add(a);
                    }
                }
                list.clear();
            }
            steps++;
        }
        return -1;
    }
}
