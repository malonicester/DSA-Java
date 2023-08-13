public class Node {
    private int data;
    private Node next;

    public Node() {
    }

    public Node(int val) {
        this.data = val;
    }

    public Node(int val, Node next) {
        this.data = val;
        this.next = next;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        Node node1 = new Node(4);
        Node node3 = new Node(3);
        node.next = node1;
        node1.next = node3;

        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(4);
        node4.next = node5;
        node5.next = node6;
        Node ans = addTwoLinkedList(node, node4);
        print(ans);
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static Node addTwoLinkedList(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node temp1 = head1;
        Node temp2 = head2;
        int rem = 0;
        temp1.data = temp1.data + temp2.data;
        rem = temp1.data / 10;
        temp1.data = temp1.data % 10;
        temp1 = temp1.next;
        temp2 = temp2.next;
        Node curr = null;
        while (temp1 != null && temp2 != null) {
            temp1.data = rem + temp1.data + temp2.data;
            rem = temp1.data / 10;
            temp1.data = temp1.data % 10;
            curr = temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            temp1.data = rem + temp1.data;
            rem = temp1.data / 10;
            temp1.data = temp1.data % 10;
            curr = temp1;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            temp2.data = rem + temp2.data;
            rem = temp2.data / 10;
            temp2.data = temp2.data % 10;
            curr.next = temp2;
            curr = curr.next;
            temp2 = temp2.next;
        }
        if (rem > 0) {
            curr.next = new Node(rem);
            curr = curr.next;
            rem /= 10;
        }
        return reverse(head1);
    }

    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
