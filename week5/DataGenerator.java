package week5;

import java.util.Random;

/**
 * คลาสสำหรับสุ่มสร้างชุดข้อมูลตัวเลขจำนวนเต็ม (int)
 * ปฏิบัติตามหลัก Single Responsibility Principle (SRP)
 */
public class DataGenerator {
    private final Random random;

    public DataGenerator() {
        this.random = new Random();
    }

    public DataGenerator(long seed) {
        this.random = new Random(seed);
    }

    /**
     * สุ่มสร้างอาร์เรย์ตัวเลขจำนวนเต็มตามขนาดที่ระบุ
     * @param size ขนาดของชุดข้อมูล (n)
     * @param min ค่าต่ำสุดที่สุ่มได้
     * @param max ค่าสูงสุดที่สุ่มได้
     * @return อาร์เรย์ int ที่มีข้อมูลสุ่มจริง
     */
    public int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    /**
     * แสดงตัวอย่างข้อมูล n ตัวแรกในอาร์เรย์เพื่อพิสูจน์การสุ่มและการเรียงลำดับ
     */
    public static String getPreview(int[] array, int limit) {
        if (array == null || array.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        int count = Math.min(array.length, limit);
        for (int i = 0; i < count; i++) {
            sb.append(String.format("%,d", array[i]));
            if (i < count - 1) sb.append(", ");
        }
        if (array.length > count) {
            sb.append(", ... (อีก ").append(String.format("%,d", array.length - count)).append(" ตัว)]");
        } else {
            sb.append("]");
        }
        return sb.toString();
    }
}
