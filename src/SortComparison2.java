import java.util.Arrays;
import java.util.Random;

public class SortComparison2 {
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000); // Generera slumpmässiga heltal mellan 0 och 9999 (kan ändras efter behov)
        }
        return arr;
    }

    public static void main(String[] args) {
        int numRuns = 1000; // Antal körningar
        int arraySize = 10000; // Storlek på arrayen

        long[] quickSortTimes = new long[numRuns];
        long[] insertionSortTimes = new long[numRuns];
        long[] mergeSortTimes = new long[numRuns];

        for (int i = 0; i < numRuns; i++) {
            int[] arr1 = generateRandomArray(arraySize);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);

            // Quick Sort
            long startTime = System.nanoTime();
            SelectionSort.selectionSort(arr1);
            //QuickSort.recurseSort(arr1, 0, arr1.length - 1);
            long endTime = System.nanoTime();
            quickSortTimes[i] = endTime - startTime;

            // Insertion Sort
            startTime = System.nanoTime();
            InsertionSort.insertionSort(arr2);
            endTime = System.nanoTime();
            insertionSortTimes[i] = endTime - startTime;

            // Merge Sort
            startTime = System.nanoTime();
            MergeSort2.mergeSort(arr3);
            endTime = System.nanoTime();
            mergeSortTimes[i] = endTime - startTime;
        }

        Arrays.sort(quickSortTimes);
        Arrays.sort(insertionSortTimes);
        Arrays.sort(mergeSortTimes);

        long medianQuickSortTime = quickSortTimes[numRuns / 2];
        long medianInsertionSortTime = insertionSortTimes[numRuns / 2];
        long medianMergeSortTime = mergeSortTimes[numRuns / 2];

        System.out.println("Median tid för Quick Sort: " + medianQuickSortTime + " nanosekunder");
        System.out.println("Median tid för Insertion Sort: " + medianInsertionSortTime + " nanosekunder");
        System.out.println("Median tid för Merge Sort: " + medianMergeSortTime + " nanosekunder");
    }

    // Övrig kod för quickSort, insertionSort, mergeSort och generateRandomArray är densamma som tidigare.
}

