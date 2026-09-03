class List {
    private int[] elements;
    private int count; // ตัวแปรเก็บจำนวนข้อมูลปัจจุบัน

    // Constructor กำหนดขนาดเริ่มต้น
    public List(int capacity) {
        elements = new int[capacity];
        count = 0;
    }

    // 1. Add() - เพิ่มข้อมูลต่อท้าย
    public void add(int value) {
        if (count < elements.length) {
            elements[count++] = value;
        } else {
            System.out.println("ไม่สามารถเพิ่มข้อมูลได้ List เต็มแล้ว");
        }
    }

    // 2. Insert() - แทรกข้อมูลลงในตำแหน่ง (Index) ที่กำหนด
    public void insert(int index, int value) {
        if (index >= 0 && index <= count && count < elements.length) {
            // เลื่อนข้อมูลไปทางขวา 1 ตำแหน่งเพื่อแทรกข้อมูลใหม่
            for (int i = count; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = value;
            count++;
        }
    }

    // 3. Search() - ค้นหาข้อมูล (คืนค่าตำแหน่ง Index ที่เจอ, ถ้าไม่เจอคืนค่า -1)
    public int search(int value) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == value) {
                return i; // พบข้อมูล
            }
        }
        return -1; // ไม่พบข้อมูล
    }

    // 4. deletion() - ลบข้อมูลที่ระบุ
    public void deletion(int value) {
        int index = search(value); // หาตำแหน่งก่อน
        if (index != -1) {
            // เลื่อนข้อมูลทางขวากลับมาทับตำแหน่งที่ลบ
            for (int i = index; i < count - 1; i++) {
                elements[i] = elements[i + 1];
            }
            count--; // ลดจำนวนข้อมูลลง
        } else {
            System.out.println("ไม่พบข้อมูลที่ต้องการลบ");
        }
    }

    // 5. Traversal() - ท่องไปในโครงสร้างเพื่อแสดงผลข้อมูลทั้งหมด
    public void traversal() {
        System.out.print("ข้อมูลใน List: ");
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    // 6. Sorting() - เรียงลำดับข้อมูล (ใช้ Bubble Sort เบื้องต้น)
    public void sorting() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    // สลับค่า
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
        System.out.println("เรียงลำดับข้อมูลเรียบร้อยแล้ว");
    }
}
