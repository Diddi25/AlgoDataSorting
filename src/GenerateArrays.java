import java.util.Random;

public class GenerateArrays {

    public int[] sorted(int n) {
        int[] sortedArray = new int[n];
        int next = new Random().nextInt(10);
        for (int i = 0; i < n; i++) {
            sortedArray[i] = next;
            next = new Random().nextInt(10) + 1;
        }
        return sortedArray;
    }

    public int[] unSorted(int n, int range) {
        int[] unSortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            unSortedArray[i] = new Random().nextInt(10);
        }
        return unSortedArray;
    }

}
