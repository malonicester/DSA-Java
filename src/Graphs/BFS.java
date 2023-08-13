package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
//        For weighted graphs
//        List<int[]> pairs = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            pairs.add(new int[2]);
//        }
//        System.out.println(pairs);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(1).add(0);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);

        adj.get(3).add(2);

        adj.get(4).add(2);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(8);

        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);

        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(5);
        adj.get(8).add(7);

        adj.get(9).add(6);
        for(List<Integer>a : adj)
            System.out.println(a);
        List<Integer> ans = breadthFirstSearch(adj);
        System.out.println(ans);
    }

    static List<Integer> breadthFirstSearch(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size() + 1];
        visited[0] = true;
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            bfs.add(node);
            for (Integer i : adj.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
}
