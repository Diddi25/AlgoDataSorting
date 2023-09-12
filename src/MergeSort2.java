public class MergeSort2 {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int mid = n / 2;

            // Dela upp arrayen i två delar
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            for (int i = mid; i < n; i++) {
                right[i - mid] = arr[i];
            }

            // Rekursivt sortera de två delarna
            mergeSort(left);
            mergeSort(right);

            // Kombinera (fusa) de sorterade delarna
            merge(arr, left, right);
        }
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int nLeft = left.length;
        int nRight = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nLeft && j < nRight) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < nLeft) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < nRight) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}

