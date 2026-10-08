package week5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * คลาสสำหรับจัดการและวัดประสิทธิภาพเวลาการทำงานของอัลกอริทึมต่าง ๆ (Benchmarking)
 */
public class SortingBenchmark {
    private final List<SortingAlgorithm> algorithms;
    private final DataGenerator dataGenerator;

    public SortingBenchmark() {
        this.algorithms = new ArrayList<>();
        this.dataGenerator = new DataGenerator();
    }

    public void addAlgorithm(SortingAlgorithm algorithm) {
        this.algorithms.add(algorithm);
    }

    /**
     * ดำเนินการทดสอบตามขนาดข้อมูลและลำดับที่ผู้ใช้เลือก
     * @param sizes อาเรย์ของขนาดข้อมูล n ที่ต้องการทดสอบตามลำดับที่กำหนด
     * @return Map เก็บผลลัพธ์เวลา (ms)
     */
    public Map<String, double[]> runBenchmark(int[] sizes) {
        Map<String, double[]> resultMap = new LinkedHashMap<>();
        for (SortingAlgorithm algo : algorithms) {
            resultMap.put(algo.getName(), new double[sizes.length]);
        }

        System.out.println("\n========================================================");
        System.out.println("       เริ่มการทดสอบประสิทธิภาพ Sorting Algorithms       ");
        System.out.println("========================================================");

        for (int i = 0; i < sizes.length; i++) {
            int n = sizes[i];
            System.out.printf("%n[รอบที่ %d/%d] ขนาดข้อมูล n = %,d%n", (i + 1), sizes.length, n);

            // 1. สุ่มข้อมูล int ขึ้นมา 1 ชุดจริง (ช่วง 1 ถึง 1,000,000)
            int[] masterData = dataGenerator.generateRandomArray(n, 1, 1_000_000);

            // แสดงตัวอย่างข้อมูลสุ่มก่อนเรียงลำดับ (5 ตัวแรก)
            System.out.println("  • ตัวอย่างข้อมูลสุ่มก่อนจัดเรียง: " + DataGenerator.getPreview(masterData, 5));

            for (SortingAlgorithm algo : algorithms) {
                // โคลนข้อมูลชุดเดียวกัน เพื่อให้ทุกอัลกอริทึมทดสอบบนข้อมูลเดียวกันอย่างยุติธรรม
                int[] dataCopy = masterData.clone();

                long startTime = System.nanoTime();
                algo.sort(dataCopy);
                long endTime = System.nanoTime();

                double elapsedMs = (endTime - startTime) / 1_000_000.0;
                resultMap.get(algo.getName())[i] = elapsedMs;

                // ตรวจสอบความถูกต้องของการเรียงลำดับ
                if (!isSorted(dataCopy)) {
                    System.err.printf("    [ข้อผิดพลาด] %s เรียงข้อมูลผิดพลาด!%n", algo.getName());
                } else {
                    System.out.printf("    ✓ %-15s : %10.3f ms   (หลังเรียง: %s)%n", 
                        algo.getName(), 
                        elapsedMs, 
                        DataGenerator.getPreview(dataCopy, 4));
                }
            }
        }

        return resultMap;
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
