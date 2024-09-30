package Graphs.practice;

import RecursionAndDP.Graphs.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInGraph {
    public static void main(String[] args) {

    }

    public static boolean detectCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (cycleExist(adj, visited, i)) return true;
        }
        return false;
    }

    private static boolean cycleExist(List<List<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(src, -1));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int node = pair.getFirst();
            int parent = pair.getSecond();
            for (Integer element : adj.get(node)) {
                if (!visited[element]) {
                    visited[element] = true;
                    queue.offer(new Pair<>(element, node));
                } else if (parent != element) {
                    return true;
                }
            }
        }
        return false;
    }
}
