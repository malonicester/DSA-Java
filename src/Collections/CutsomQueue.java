package Collections;

import java.util.ArrayList;
import java.util.List;

public class CutsomQueue<E> {
    private int front;
    private int rear;
    private List<E> list;

    public CutsomQueue() {
        front = rear = -1;
        list = new ArrayList<>();
    }

    E front() {
        if (front == -1) {
            return null;
        }
        return list.get(front);
    }

    E rear() {
        if (rear == -1) {
            return null;
        }
        return list.get(rear);
    }

    void enqueue(E e) {
        if (this.list.isEmpty()) {
            front = 0;
            rear = 0;
            list.add(e);
        } else {
            front++;
            if (list.size() > front) {
                list.set(front, e);
            } else {
                list.add(e);
            }
        }
    }

    public static void main(String[] args) {
        CutsomQueue<Integer> q = new CutsomQueue<>();
        q.enqueue(4);
        q.enqueue(6);
    }
}
