
public class Benchmark {
    public static void main(String[] args) {
        System.out.printf("#%4s%12s%11s%7s%8s\n", "n", "selection", "insertion", "merge", "quick\n");
        benchmark();
    }
    private static final int tries = 1;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void benchmark() {
        int[] sizes = {100, 250, 500, 1000, 2500, 4000};

        for(int n : sizes) {
            int[] array1 = GenerateArrays.unSorted(n);
            int[] array2 = GenerateArrays.unSorted(n);
            int[] array3 = GenerateArrays.unSorted(n);
            int[] array4 = GenerateArrays.unSorted(n);

            System.out.printf("%5d", n);
            float min1 = benchmarkSelectionSort(array1);
            System.out.printf("%12.0f", min1/1000);

            restoreMin();
            float min2 = benchmarkInsertionSort(array2);
            System.out.printf("%9.0f", min2/1000);

            restoreMin();
            float min3 = benchmarkMergeSort(array3);
            System.out.printf("%11.0f", min3/1000);

            restoreMin();
            float min4 = benchmarkQuickSort(array4);
            System.out.printf("%10.0f\n", min4/1000);
        }
    }
    private static float benchmarkSelectionSort(int[] array) {
        for (int i = 0; i < tries; i++) {
            int[] clone = array.clone();
            long t0 = System.nanoTime();
            SelectionSort.selectionSort(clone);
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
        }
        return min;
    }
    private static float benchmarkInsertionSort(int[] array) {
        for (int i = 0; i < tries; i++) {
            int[] clone = array.clone();
            long t0 = System.nanoTime();
            InsertionSort.insertionSort(clone);
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
        }
        return min;
    }
    private static float benchmarkMergeSort(int[] array) {
        for (int i = 0; i < tries; i++) {
            int[] clone = array.clone();
            long t0 = System.nanoTime();
            MergeSort.mergeSort(clone);
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
        }
        return min;
    }
    private static float benchmarkQuickSort(int[] array) {
        for (int i = 0; i < tries; i++) {
            int[] clone = array.clone();
            long t0 = System.nanoTime();
            QuickSort.quickSort(clone);
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
        }
        return min;
    }
    public static void restoreMin() {
        min = Float.POSITIVE_INFINITY;
        max = -1;
    }
}
