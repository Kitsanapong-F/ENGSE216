package week5;

/**
 * Quick Sort Algorithm
 * Time Complexity: O(n log n) (Worst Case: O(n^2))
 * Space Complexity: O(log n)
 */
public class QuickSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        // เลือก pivot จากตำแหน่งตรงกลางเพื่อลดโอกาสเกิด Worst Case
        int mid = low + (high - low) / 2;
        int pivot = array[mid];

        // สลับ pivot ไปไว้ที่ตำแหน่ง high ชั่วคราว
        swap(array, mid, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        // สลับ pivot กลับมาไว้ที่ตำแหน่งที่ถูกต้อง (i + 1)
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}

