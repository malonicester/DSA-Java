package RecursionAndDP.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInGraph {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 2},
                {1, 2},
                {2, 3},
                {4, 3}
        };
        boolean ans = detectCycleInUndirectedGraphUsingDFS(1, -1, getAdj(arr), new boolean[getAdj(arr).size() + 1]);
        System.out.println(ans);
    }

    private static boolean detectCycleInUndirectedGraph(int[][] edges) {
        List<List<Integer>> adj = getAdj(edges);
        boolean[] visited = new boolean[adj.size() + 1];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(1, 0));
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.peek().getFirst();
            int parent = queue.peek().getSecond();
            queue.poll();
            for (int elem : adj.get(node)) {
                if (!visited[elem]) {
                    queue.offer(new Pair<>(elem, node));
                    visited[elem] = true;
                } else if (elem != parent) {
                    return true;
                }
            }
        }
        return false;
    }


    private static List<List<Integer>> getAdj(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int first = arr[i][0];
            int second = arr[i][1];
            list.get(first).add(second);
            list.get(second).add(first);
        }
        return list;
    }

    private static boolean detectCycleInUndirectedGraphUsingDFS(int src, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[src] = true;
        for (int element : adj.get(src)) {
            if (!visited[element]) {
                if (detectCycleInUndirectedGraphUsingDFS(element, src, adj, visited)) return true;
            } else if (element != parent) return true;
        }
        return false;
    }

}
