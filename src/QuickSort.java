public class QuickSort {
    public static void quickSort(int[] array) {
        recurseSort(array, 0, array.length - 1);
    }
    private static void recurseSort(int[] array, int min, int max) {
        if (min < max) {
            int partitionIndex = partition(array, min, max);
            recurseSort(array, min, partitionIndex - 1);
            recurseSort(array, partitionIndex + 1, max);
        }
    }
    private static int partition(int[] array, int min, int max) {
        int pivot = array[max];
        int i = min - 1;
        for (int j = min; j < max; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array,i + 1, max);
        return i + 1;
    }
    private static void swap(int[] array, int i, int j) {
        int swapElement = array[i];
        array[i] = array[j];
        array[j] = swapElement;
    }
}
