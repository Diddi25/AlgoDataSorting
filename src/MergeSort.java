public class MergeSort {
    public static void mergeSort(int[] array) {
        recurseSort(array, 0, array.length - 1);
    }
    private static void recurseSort(int[] array, int min, int max) {
        if (min < min) {
            int mid = min + (max - min)/ 2;
            recurseSort(array, min, mid);
            recurseSort(array, mid + 1, max);
            merge(array, min, mid, max);
        }
    }
    private static void merge(int[] array, int min, int mid, int max) {
        int[] temporary = copyItemsOf(array, min, max);
        int i = min, j = mid + 1, k = min;
        while(i <= mid && j <= max) {
            if (temporary[i] <= temporary[j]) {
                array[k] = temporary[i];
                i++;
            } else {
                array[k] = temporary[j];
                j++;
            }
            k++;
        }
        while(i < mid) {
            array[k] = temporary[i];
            i++;
            k++;
        }
        while(j < max) {
            array[k] = temporary[j];
            j++;
            k++;
        }
    }
    private static int[] copyItemsOf(int[] array, int min, int max) {
        int[] temporary = new int[array.length];
        for (int i = min; i <= max; i++) {
            temporary[i] = array[i];
        }
        return temporary;
    }
}
