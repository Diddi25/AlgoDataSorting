public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int candidate = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < min) {
                    min = array[j];
                    candidate = j;
                }
            }
            array = swap(array, i, candidate);
        }
        return array;
    }

    private static int[] swap(int[] array, int i, int swapElement) {
        int swap = array[i];
        array[i] = array[swapElement];
        array[swapElement] = swap;
        return array;
    }

}
