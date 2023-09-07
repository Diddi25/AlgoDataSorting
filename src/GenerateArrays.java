import java.util.Random;

public class GenerateArrays {

    public static int[] sorted(int n) {
        int[] sortedArray = new int[n];
        int next = new Random().nextInt(10);
        for (int i = 0; i < n; i++) {
            sortedArray[i] = next;
            next = new Random().nextInt(10) + 1;
        }
        return sortedArray;
    }

    public static int[] unSorted(int n) {
        int[] unSortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            unSortedArray[i] = new Random().nextInt(10);
        }
        return unSortedArray;
    }

}
