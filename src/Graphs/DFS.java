package Graphs;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<>();
        boolean add = queue.add(new int[]{1,2,3,3,3});
        System.out.println(Arrays.toString(queue.peek()));
    }

    static List<Integer> depthFirstSearch(List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        return dfs;
    }
}
