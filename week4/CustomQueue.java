package week4;

public class CustomQueue {
    private int[] queueArray;
    private int front;    // ชี้ตำแหน่งข้อมูลหัวคิว
    private int rear;     // ชี้ตำแหน่งข้อมูลท้ายคิว
    private int capacity; // ความจุสูงสุดของคิว
    private int count;    // จำนวนข้อมูลปัจจุบัน (size)

    // Constructor สร้าง Queue ตามขนาดที่กำหนด
    public CustomQueue(int size) {
        this.capacity = size;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // 1. enqueue - เพิ่มข้อมูลเข้าท้ายคิว
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue เต็ม! ไม่สามารถเพิ่ม " + value + " ได้");
            return;
        }
        // เลื่อน rear ไปข้างหน้าแบบวงกลม
        rear = (rear + 1) % capacity;
        queueArray[rear] = value;
        count++;
    }

    // 2. dequeue - นำข้อมูลออกจากหัวคิว
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue ว่างเปล่า! ไม่มีข้อมูลให้ดึงออก");
            return null;
        }
        int value = queueArray[front];
        // เลื่อน front ไปข้างหน้าแบบวงกลม
        front = (front + 1) % capacity;
        count--;
        return value;
    }

    // 3. isFull - เช็กว่าคิวเต็มหรือไม่
    public boolean isFull() {
        return count == capacity;
    }

    // 4. isEmpty - เช็กว่าคิวว่างหรือไม่
    public boolean isEmpty() {
        return count == 0;
    }

    // 5. size - คืนค่าจำนวนข้อมูลในคิวปัจจุบัน
    public int size() {
        return count;
    }
}
