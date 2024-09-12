package SlidingWindowAndTwoPointers;

import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {

    }

    private final Stack<Pair> st;

    OnlineStockSpan() {
        this.st = new Stack<>();
    }

    private int onlineStockSpan(int price) {
        int count = 1;
        while (!st.isEmpty() && st.peek().getFirst() <= price) {
            count += st.pop().getSecond();
        }
        st.push(new Pair(price, count));
        return count;
    }

    private class Pair {
        final int first;
        final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return this.first;
        }

        public int getSecond() {
            return this.second;
        }
    }
}
