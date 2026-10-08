package week5;

import java.util.Map;

/**
 * คลาสสำหรับวาดกราฟแท่งเปรียบเทียบใน Terminal
 * ใช้รูปแบบ ASCII มาตรฐาน ป้องกันปัญหาเครื่องหมายคำถาม (?) บน Windows PowerShell
 */
public class ConsoleGraph {

    private static final int BAR_WIDTH = 38; // ความยาวของแท่งกราฟ

    public static void printComparison(int[] sizes, Map<String, double[]> results) {
        System.out.println("\n+================================================================================+");
        System.out.println("|                Console Bar Chart - Sorting Performance Comparison              |");
        System.out.println("+================================================================================+");

        for (int sizeIndex = 0; sizeIndex < sizes.length; sizeIndex++) {
            int n = sizes[sizeIndex];

            // หาเวลาสูงสุดสำหรับทำสัดส่วน
            double maxTime = 0.0001;
            for (double[] times : results.values()) {
                if (times[sizeIndex] > maxTime) {
                    maxTime = times[sizeIndex];
                }
            }

            System.out.println("+--------------------------------------------------------------------------------+");
            System.out.printf("| Data Size: n = %-63s |%n", String.format("%,d", n));
            System.out.println("+-----------------+----------------------------------------+---------------------+");

            for (Map.Entry<String, double[]> entry : results.entrySet()) {
                String algoName = entry.getKey();
                double time = entry.getValue()[sizeIndex];

                // คำนวณความยาวแถบ
                int filledLength = (int) Math.round((time / maxTime) * BAR_WIDTH);
                if (filledLength == 0 && time > 0) filledLength = 1;

                StringBuilder bar = new StringBuilder("[");
                for (int b = 0; b < filledLength; b++) {
                    bar.append("=");
                }
                for (int b = filledLength; b < BAR_WIDTH; b++) {
                    bar.append(" ");
                }
                bar.append("]");

                System.out.printf("| %-15s | %s | %15.3f ms |%n", algoName, bar.toString(), time);
            }
            System.out.println("+-----------------+----------------------------------------+---------------------+");
        }
        System.out.println();
    }
}
