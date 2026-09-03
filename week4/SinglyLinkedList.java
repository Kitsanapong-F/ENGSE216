package week4;

public class SinglyLinkedList {

    // สร้างคลาส Node สำหรับเก็บข้อมูลและตัวชี้
    class Node {
        int data;
        Node next; // ชี้ไปโหนดถัดไป

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null; // หัวลิสต์
    private Node tail = null; // ท้ายลิสต์

    // เมธอดสำหรับเพิ่มข้อมูลต่อท้ายลิสต์
    public void addNode(int data) {
        Node newNode = new Node(data);

        // ถ้าลิสต์ยังว่าง ให้ head และ tail ชี้ไปที่โหนดใหม่
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // ถ้าไม่ว่าง ให้ต่อโหนดใหม่ไว้ด้านหลัง tail แล้วขยับ tail ไปที่โหนดใหม่
            tail.next = newNode;
            tail = newNode;
        }
    }

    // เมธอดสำหรับแสดงผลข้อมูล
    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("ลีสต์ว่างเปล่า");
            return;
        }

        System.out.print("Singly Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next; // ขยับไปโหนดถัดไป
        }
        System.out.println("null");
    }
}
