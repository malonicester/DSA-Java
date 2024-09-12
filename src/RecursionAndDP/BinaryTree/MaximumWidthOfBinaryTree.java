package RecursionAndDP.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {

    }

    private static int maximumWidthOfBinaryTree(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        queue.offer(new Pair(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            /*
              MinIndex from the last level to keep the index under the valid range of integer
              like if we Initialize as 2 * index and 2 * index + 1 at each step
              at a level 2 ( 2 (2 * index) * index ) * index at this rate we will reach the integer overflow at very fast pace
              better to keep it minimum possible so  minimizing it by subtracting the minimum index of
              that level which is the index of the first element of the
              queue at each level
             */
            int minIndex = queue.peek().getSecond();
            /*
                Initializing min and max so that keep left index for the left most element in the level
                and max at the right most element of that level
             */
            int min = 0, max = 0;
            for (int i = 0; i < size; i++) {
                int currentIndex = queue.peek().getSecond() - minIndex + 1;
                Node node = queue.poll().getFirst();
                if (i == 0) min = currentIndex;
                if (i == size - 1) max = currentIndex;
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * currentIndex));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * currentIndex + 1));
                }
            }
/*

 */
            res = Math.max(res, max - min + 1);
        }

        return res;
    }

    private static class Pair {
        Node node;
        int index;

        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }

        public Node getFirst() {
            return this.node;
        }

        public int getSecond() {
            return this.index;
        }
    }

}

