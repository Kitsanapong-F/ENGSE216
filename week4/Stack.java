package week4;
public class Stack {
    private int maxSize;      // ขนาดความจุสูงสุดของ Stack
    private int[] stackArray; // Array สำหรับเก็บข้อมูล
    private int top;          // ตัวชี้ตำแหน่งข้อมูลบนสุดของ Stack (Top of Stack)

    // Constructor สำหรับกำหนดขนาดและสร้าง Stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // เริ่มต้นที่ -1 หมายถึง Stack ยังว่างเปล่า
    }

    // 1. การเพิ่มข้อมูลใน STACK (Push)
    public void push(int value) {
        if (isFull()){
            System.out.println("Stack เต็ม! ไม่สามารถเพิ่มข้อมูล " + value + " ได้");
            return;
        }
        // เพิ่มค่า top ขึ้น 1 ตำแหน่ง แล้วนำข้อมูลไปเก็บไว้ที่ตำแหน่งนั้น
        stackArray[++top] = value;
    }

    // 2. การดึงข้อมูลจาก STACK (Pop)
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack ว่างเปล่า! ไม่มีข้อมูลให้ดึงออก");
            return null; // หรือทำการ Throw Exception ในการใช้งานจริง
        }
        // คืนค่าตำแหน่งบนสุด แล้วลดค่า top ลง 1
        return stackArray[top--];
    }

    // 3. จำนวนข้อมูลที่มีใน STACK (Size)
    public int size() {
        // เนื่องจาก array index เริ่มที่ 0 (และ top เริ่มที่ -1) จำนวนจริงจึงต้อง + 1
        return top + 1;
    }

    // 4. การทดสอบสถานะของ STACK: ว่างหรือไม่
    public boolean isEmpty() {
        return (top == -1);
    }

    // 5. การทดสอบสถานะของ STACK: เต็มหรือไม่
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
