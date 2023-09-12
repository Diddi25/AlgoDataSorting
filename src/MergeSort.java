public class MergeSort {
    public static void mergeSort(int[] array) {
        int[] temporary = new int[array.length];
        recurseSort(array, temporary, 0, array.length - 1);
    }
    private static void recurseSort(int[] array, int[] extra, int min, int max) {
        if (min < max) {
            int mid = (max + min) / 2;
            recurseSort(extra, array, min, mid);
            recurseSort(extra, array, mid + 1, max);
            merge(array, extra, min, mid, max);
        }
    }
    private static void merge(int[] array, int[] temporary, int min, int mid, int max) {
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
        while(i <= mid) {
            array[k] = temporary[i];
            i++;
            k++;
        }
        while(j <= max) {
            array[k] = temporary[j];
            j++;
            k++;
        }
    }
}
