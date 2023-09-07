public class Benchmark {
    public static void main(String[] args) {
        benchmark();
    }
    private static final int tries = 1000;
    private static float min = Float.POSITIVE_INFINITY;
    public static void benchmark() {
        int[] sizes = {100, 200, 400, 800, 1600, 3200};

        System.out.printf(#%s4, );
        for(int n : sizes) {
            int[] array1 = GenerateArrays.unSorted(n);
            int[] array2 = GenerateArrays.unSorted(n);
            int[] array3 = GenerateArrays.unSorted(n);
            int[] array4 = GenerateArrays.unSorted(n);

            float min1 = benchmarkSelectionSort(array1);
            System.out.println(min1);
            restoreMin();
            float min2 = benchmarkInsertionSort(array2);
            System.out.println(min2);
            restoreMin();
            float min3 = benchmarkMergeSort(array3);
            System.out.println(min3);
            restoreMin();
            float min4 = benchmarkQuickSort(array4);
            System.out.println(min4);
        }
    }
    private static float benchmarkSelectionSort(int[] array) {
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            SelectionSort.selectionSort(array);
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
            long t0 = System.nanoTime();
            InsertionSort.insertionSort(array);
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
            long t0 = System.nanoTime();
            MergeSort.mergeSort(array);
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
            long t0 = System.nanoTime();
            QuickSort.quickSort(array);
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
    }
}
