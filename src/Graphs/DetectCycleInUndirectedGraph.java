package Graphs;

import java.util.*;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {

    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (detectCycle(i, adjList, visited)) return true;
        }
        return false;
    }

    static boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[0] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();
            for (Integer elem : adjList.get(node)) {
                if (!visited[elem]) {
                    visited[elem] = true;
                    queue.add(new Pair(elem, node));
                } else if (parent != elem) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean detectCycle(int src, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        visited[src] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, -1});
        while (!queue.isEmpty()) {
            int node = queue.peek()[0];
            int parent = queue.peek()[1];
            queue.remove();
            for (Integer edge : adjList.get(node)) {
                if (!visited[edge]) {
                    visited[edge] = true;
                    queue.add(new int[]{edge, node});
                } else if (parent != edge) {
                    return true;
                }
            }
        }
        return false;
    }
}

