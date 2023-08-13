package Important_Questions;

public class CircularQueue {
    private int[] arr;
    int front = 0;
    int rear = 0;
    int count = 0;
    int size;

    void enque(int data) {
        if (count == size) {
            System.out.println("Queue is full");
            return;
        }
        arr[front] = data;
        count++;
        front = (++front % size);
    }
    void deque(){
        if (count==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(arr[rear]);
        count--;
        rear = (rear+1)%size;
    }
    public CircularQueue(int n) {
        this.arr = new int[n];
        this.size = arr.length;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enque(5);
        q.enque(3);
//        q.deque();
//        q.deque();
//        q.deque();
        q.enque(4);
        q.enque(10);
        q.enque(6);

        q.enque(56);
        int a = 10;
        int b = a--;
        b  = b + --a;
        System.out.println(--a);

    }
}
