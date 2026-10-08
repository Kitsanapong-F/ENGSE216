package week5;

import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * คลาสสำหรับควบคุม Flow การทำงานทั้งหมดของ Benchmark (Controller Layer)
 * แยกตรรกะออกจาก Main ตามหลัก Single Responsibility Principle (SRP)
 */
public class BenchmarkController {

    private static final int[] DEFAULT_SIZES = { 500, 1_000, 10_000, 50_000, 100_000 };

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================================");
        System.out.println("      Sorting Algorithms Benchmark System (OOP)                   ");
        System.out.println("==================================================================");
        System.out.println("ขนาดข้อมูลมาตรฐานตามโจทย์:");
        for (int i = 0; i < DEFAULT_SIZES.length; i++) {
            System.out.printf("  [%d] n = %,d%n", (i + 1), DEFAULT_SIZES[i]);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("เลือกรูปแบบการทดสอบ:");
        System.out.println("  1. รันตามลำดับมาตรฐานทั้งหมด (500 -> 1,000 -> 10,000 -> 50,000 -> 100,000)");
        System.out.println("  2. เลือกลำดับและขนาดเอง (เช่น พิมพ์: 3, 1, 4)");
        System.out.println("  3. ระบุขนาด n เองอิสระ (เช่น พิมพ์: 2000, 15000)");
        System.out.print("เลือกตัวเลือก (1, 2 หรือ 3) [กด Enter เพื่อเลือก 1]: ");

        String choice = scanner.nextLine().trim();
        int[] selectedSizes;

        if (choice.equals("2")) {
            selectedSizes = promptCustomOrder(scanner);
        } else if (choice.equals("3")) {
            selectedSizes = promptCustomSizes(scanner);
        } else {
            selectedSizes = DEFAULT_SIZES;
            System.out.println("-> เลือกทดสอบทั้งหมดตามลำดับมาตรฐาน");
        }

        // จัดการรันการทดสอบ (Polymorphism)
        SortingBenchmark benchmark = new SortingBenchmark();
        benchmark.addAlgorithm(new BubbleSort());
        benchmark.addAlgorithm(new SelectionSort());
        benchmark.addAlgorithm(new InsertionSort());
        benchmark.addAlgorithm(new QuickSort());

        Map<String, double[]> benchmarkResults = benchmark.runBenchmark(selectedSizes);

        // 1. แสดงเฉพาะกราฟแท่งใน Terminal
        ConsoleGraph.printComparison(selectedSizes, benchmarkResults);

        // 2. แสดงหน้าต่างกราฟเส้น GUI
        if (!GraphicsEnvironment.isHeadless()) {
            System.out.println("[กำลังเปิดหน้าต่างกราฟ GUI: SortingGraphWindow...]");
            SwingUtilities.invokeLater(() -> {
                SortingGraphWindow window = new SortingGraphWindow(selectedSizes, benchmarkResults);
                window.setVisible(true);
            });
        }
    }

    private int[] promptCustomOrder(Scanner scanner) {
        System.out.println("\nระบุหมายเลขขนาดข้อมูลที่ต้องการทดสอบ คั่นด้วยเครื่องหมายจุลภาค (,)");
        System.out.println("เช่น: 3, 1, 5 (จะทดสอบ n = 10,000 ก่อน แล้วตามด้วย 500 และ 100,000)");
        System.out.print("ลำดับที่ต้องการ: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) return DEFAULT_SIZES;

        String[] parts = input.split("[,\\s]+");
        List<Integer> list = new ArrayList<>();
        for (String p : parts) {
            try {
                int index = Integer.parseInt(p.trim()) - 1;
                if (index >= 0 && index < DEFAULT_SIZES.length) {
                    list.add(DEFAULT_SIZES[index]);
                }
            } catch (NumberFormatException ignored) {}
        }
        if (list.isEmpty()) return DEFAULT_SIZES;

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

    private int[] promptCustomSizes(Scanner scanner) {
        System.out.println("\nป้อนขนาดข้อมูล n ที่ต้องการทดสอบ คั่นด้วยเครื่องหมายจุลภาค (,)");
        System.out.println("เช่น: 1500, 8000, 25000");
        System.out.print("ขนาดข้อมูลที่ต้องการ: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) return DEFAULT_SIZES;

        String[] parts = input.split("[,\\s]+");
        List<Integer> list = new ArrayList<>();
        for (String p : parts) {
            try {
                int size = Integer.parseInt(p.trim());
                if (size > 0) list.add(size);
            } catch (NumberFormatException ignored) {}
        }
        if (list.isEmpty()) return DEFAULT_SIZES;

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}

