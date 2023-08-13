package DSA421;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        print(head);
        Node prev = null;
        Node curr = head;
        head = reverse(head);
        print(head);
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
