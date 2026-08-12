package week3;

public class Main {
    public static void main(String[] args) {
        CirclularQueue cq = new CirclularQueue(5);
        cq.enqueue(1);
        cq.enqueue(5);
        cq.enqueue(3);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.showAll();
        cq.showActive();

    }
}
