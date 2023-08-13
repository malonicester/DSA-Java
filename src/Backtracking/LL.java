package Backtracking;

public class LL<T> {
    private Node<T> head;

    public void insertLast(T val) {
        Node<T> node = new Node<>(val);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void reverse() {
        Node<T> temp = head;
        Node<T> curr = head;
        Node<T> prev = null;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    //    Retain n,delete m
    public void keepMDeleteN(int n, int m) {
        Node<T> temp = head, curr = null;
        while (temp != null) {
            for (int count = 1; count < m && temp != null; count++) {
                temp = temp.next;
            }
            if (temp == null) return;
            curr = temp.next;
            for (int count = 1; count <= n && curr != null; count++) {
                Node<T> temp2 = curr;
                curr = curr.next;
            }
            temp.next = curr;
            temp = curr;
        }
    }

    public void keepXDeleteN(int x, int y) {
        Node<T> temp = head, curr = null;
        while (temp != null) {
            for (int count = 1; count < x && temp != null; count++) {
                temp = temp.next;
            }
            if (temp == null) return;
            curr = temp.next;
            for (int count = 1; count <= y && curr != null; count++) {
                curr = curr.next;
            }
            temp.next = curr;
            temp = curr;
        }
    }

    private Node<T> node;

    private class Node<T> {
        public T val;
        public LL<T>.Node<T> next;

        public Node() {
        }

        public Node(T val) {
            this.val = val;
        }

        public Node(T val, LL<T>.Node<T> next) {
            this.val = val;
            this.next = next;
        }


        @Override

        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LL<Integer> linkedList = new LL<>();
        linkedList.insertLast(4);
        linkedList.insertLast(5);
        linkedList.insertLast(6);
        linkedList.reverse();
        linkedList.print();
    }
}
