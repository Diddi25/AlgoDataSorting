public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            array = swap(array, i, index);
        }
        return array;
    }
    private static int[] swap(int[] array, int i, int swapIndex) {
        int swap = array[i];
        array[i] = array[swapIndex];
        array[swapIndex] = swap;
        return array;
    }
}
