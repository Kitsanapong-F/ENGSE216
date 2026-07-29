package week3;

public class CirclularQueue {
    int arr[];
    int front, rear, count;

    public CirclularQueue() {
        this(5);
    }

    public CirclularQueue(int size) {
        this.arr = new int[size];
        this.count = 0;
        this.front = -1;
        this.rear = -1;
    }

    void enqueue(int item) {
        if (!isFull()) {
            if (isEmpty()) {
                this.front = 0;
                this.rear = 0;
                arr[rear] = item;
                count++;
            } else {// after inti
                rear = (rear + 1) % arr.length;
                arr[rear] = item;
                count++;
            }
        } else
            System.out.println("Queue is full");
    }

    int dequeue() {
        int data = -1;
        if (!isEmpty()) {
            data = arr[this.front];
            if (front == rear) {
                this.front = -1;
                this.rear = -1;
            } else
                front = (front + 1) % arr.length;
            count--;
        } else
            System.out.print("empty");
        return data;
    }

    boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
    }

    boolean isFull() {
        return count == arr.length;
    }

    int size() {
        return this.arr.length;
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[front];
        } else {
            System.out.println(" empty");
            return -1;
        }
    }

    void showAll() {
        System.out.println("Front: " + this.front);
        System.out.println("Rear: " + this.rear);
        System.out.println("Count: " + this.count);
    }

    void showArr() {
        System.out.print("arr[" + size() + "] =");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("");
    }

    void showActive() {
        System.out.print("active(" + count + ") =");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + arr[(front + i) % arr.length]);
        }
        System.out.println();
    }
}
