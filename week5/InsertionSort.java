package week5;

/**
 * Insertion Sort Algorithm
 * Time Complexity: O(n^2) (Best Case: O(n))
 * Space Complexity: O(1)
 */
public class InsertionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;

        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // เลื่อนสมาชิกที่มากกว่า key ไปข้างหน้า 1 ตำแหน่ง
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}

