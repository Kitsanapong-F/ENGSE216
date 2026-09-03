package week4;

public class CircularQueue {
    private int[] queue;
    private int front;    // ชี้ตำแหน่งหัวคิว (ข้อมูลที่จะถูกนำออก)
    private int rear;     // ชี้ตำแหน่งท้ายคิว (ข้อมูลที่เพิ่งเพิ่มเข้ามา)
    private int capacity; // ขนาดสูงสุดของคิว
    private int count;    // จำนวนข้อมูลที่มีอยู่ในคิวปัจจุบัน

    // Constructor: กำหนดขนาดเริ่มต้นของคิว
    public CircularQueue(int size) {
        this.capacity = size;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // 1. enqueue - เพิ่มข้อมูลเข้าท้ายคิว
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue เต็ม! ไม่สามารถเพิ่มข้อมูล " + value + " ได้");
            return;
        }
        // เลื่อน rear ไปข้างหน้าแบบวงกลม
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        count++;
        System.out.println("เพิ่มข้อมูล: " + value + " (ตำแหน่ง rear: " + rear + ")");
    }

    // 2. dequeue - ดึงข้อมูลออกจากหัวคิว
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue ว่างเปล่า! ไม่มีข้อมูลให้ดึงออก");
            return null;
        }
        int value = queue[front];
        System.out.println("ดึงข้อมูล: " + value + " ออกจาก (ตำแหน่ง front: " + front + ")");

        // เลื่อน front ไปข้างหน้าแบบวงกลม
        front = (front + 1) % capacity;
        count--;

        return value;
    }

    // 3. isFull - ตรวจสอบว่าคิวเต็มหรือไม่
    public boolean isFull() {
        return count == capacity;
    }

    // 4. isEmpty - ตรวจสอบว่าคิวว่างหรือไม่
    public boolean isEmpty() {
        return count == 0;
    }

    // 5. size - คืนค่าจำนวนข้อมูลปัจจุบันในคิว
    public int size() {
        return count;
    }
}
