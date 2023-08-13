package Revision.LinkedList;

import java.util.Arrays;
import java.util.Stack;

public class LL {

    private ListNode head;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.data);
            sb.append("->");
            temp = temp.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public void add(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode ListNode = new ListNode(data);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = ListNode;
    }

    public void reverse() {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int[] nextGreaterElement() {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        reverse();
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[size];
        temp = head;
        int idx = arr.length - 1;
        while (temp != null) {
            while (!st.isEmpty() && st.peek() <= temp.data) {
                st.pop();
            }
            if (st.isEmpty()) {
                arr[idx--] = 0;
            }else{
                arr[idx--] = st.peek();
            }
            st.push(temp.data);
            temp = temp.next;
        }
        return arr;
    }

    private class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LL ll = new LL();
        ll.add(2);
        ll.add(7);
        ll.add(4);
        ll.add(3);
        ll.add(5);

        int[]ans = ll.nextGreaterElement();
        System.out.println(Arrays.toString(ans));
        System.out.println(ll);
    }
}
