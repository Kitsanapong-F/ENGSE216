package week5;

/**
 * Selection Sort Algorithm
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class SelectionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}

