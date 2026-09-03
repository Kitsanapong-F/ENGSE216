package week4;

public class DoublyLinkedList {

    // สร้างคลาส Node สำหรับ Doubly Linked List
    class Node {
        int data;
        Node prev; // ชี้ไปโหนดก่อนหน้า
        Node next; // ชี้ไปโหนดถัดไป

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // เมธอดสำหรับเพิ่มข้อมูลต่อท้ายลิสต์
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // ให้ next ของ tail เดิมชี้ไปโหนดใหม่
            tail.next = newNode;
            // ให้ prev ของโหนดใหม่ชี้กลับมาที่ tail เดิม
            newNode.prev = tail;
            // ขยับ tail ไปที่โหนดใหม่
            tail = newNode;
        }
    }

    // เมธอดแสดงผลจากหน้าไปหลัง (เหมือน Singly)
    public void displayForward() {
        Node current = head;
        System.out.print("Doubly (เดินหน้า): null <-> ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // เมธอดแสดงผลจากหลังมาหน้า (ทำได้เพราะมีตัวชี้ prev)
    public void displayBackward() {
        Node current = tail;
        System.out.print("Doubly (ถอยหลัง): null <-> ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev; // ถอยกลับไปโหนดก่อนหน้า
        }
        System.out.println("null");
    }
}
