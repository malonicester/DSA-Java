package RecursiveSorting;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        Node n4 = new Node(8);
        Node n5 = new Node(2);
        Node n6 = new Node(100);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n1 = mergeSort(n1);
        print(n1);
    }
    static void print(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = mid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);
        Node res = merge(left, right);
        return res;
    }

    private static Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        Node dummy = new Node(-1);
        dummy.next = left;
        Node temp = dummy;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left!=null){
            temp.next = left;
        }
        if (right!=null){
            temp.next = right;
        }
        return dummy.next;
    }

    static Node mid(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
