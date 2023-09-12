import java.util.Arrays;
import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        long minQuickSortTime = Long.MAX_VALUE;
        long minInsertionSortTime = Long.MAX_VALUE;

        for (int i = 0; i < 100; i++) {
            arr1 = generateRandomArray(10000); // Justera storleken efter behov
            arr2 = Arrays.copyOf(arr1, arr1.length); // Skapar en kopia av arr1 för att användas med Insertion Sort

            long startTime, endTime, duration;

            // QuickSort
            startTime = System.nanoTime();
            quickSort(arr1, 0, arr1.length - 1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            minQuickSortTime = Math.min(minQuickSortTime, duration);

            // Insertion Sort
            startTime = System.nanoTime();
            insertionSort(arr2);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            minInsertionSortTime = Math.min(minInsertionSortTime, duration);
        }

        System.out.println("Snabbaste QuickSort-tid: " + minQuickSortTime  + " ns");
        System.out.println("Snabbaste Insertion Sort-tid: " + minInsertionSortTime  + " ns");
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000); // Slumpmässiga heltal mellan 0 och 999999
        }
        return arr;
    }
}
