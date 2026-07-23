package week3;

public class Queue {
    int arr[];
    int queueCount, front, rear;

    public Queue() {
        this(5);
    }

    public Queue(int size) {
        this.arr = new int[size];
        this.queueCount = 0;
        this.front = 0;
        this.rear = -1;
    }

    void enqueue(int item) {
        if (!isFull()) {
            rear++;
            this.arr[rear] = item;
            queueCount++;
        } else
            System.out.println("Queue is full.");
    }

    public int dequeue() {
        int data = -1;
        if (!isEmpty()) {
            data = arr[front];
            front++; 
            queueCount--;
        } else
            System.out.println("The queue is empty.");
        return data;
    }

    int size() {
        return queueCount;
    }

    boolean isFull() {
        return queueCount == arr.length;
    }

    boolean isEmpty() {
        return queueCount == 0;
    }

    void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("In queue : ");
        for (int i = front; i < rear + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
