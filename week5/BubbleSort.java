package week5;

/**
 * Bubble Sort Algorithm
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // ถ้าไม่มีการสลับตำแหน่งเลย แสดงว่าข้อมูลเรียงลำดับเรียบร้อยแล้ว
            if (!swapped) break;
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}

