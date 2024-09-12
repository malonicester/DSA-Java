package SlidingWindowAndTwoPointers;

import java.util.List;

public class DLL {

    private Node head;

    public Node getAsDoublyLinkedList(List<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        head = new Node(list.get(0));
        Node temp = head;
        int i = 1;
        while (i < list.size()) {
            Node node = new Node(list.get(i++));
            node.prev = temp;
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public void removeNode(int val) {
        Node temp = head;
        int position = 0;
        while (temp != null && temp.val != val) {
            temp = temp.next;
            position++;
        }
        if (temp == null) throw new RuntimeException("Node not found");
        temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
//      Node to be deleted
        Node node = temp.next;
//      Removing previous Pointer
        node.prev = null;
        Node next = node.next;
        temp.next = next;
        node.next = null;
        if (next != null) next.prev = temp;
        print();
    }

    public void reverse() {
        if (head == null) return;
        Node node = head;
        Node prev = null;
        Node curr = node;
        while (curr != null) {
            Node next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
        print();
    }


    public void print() {
        Node temp = head;
        System.out.println("Head To Tail");
        while (temp.next != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println(temp.val + "->null");

        while (temp.prev != null) {
            System.out.print(temp.val + "->");
            temp = temp.prev;
        }
        System.out.println(temp.val + "->null");
        System.out.println("Tail To Tail");
    }

    private class Node {
        Node next;
        Node prev;
        int val;

        public Node(Node next, Node prev, int val) {
            this.next = next;
            this.prev = prev;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        DLL dll = new DLL();
        Node node = dll.getAsDoublyLinkedList(list);
        dll.reverse();
    }
}
