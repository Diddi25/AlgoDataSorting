public class Main {
    public static void main(String[] args) {

        int[] testArray = GenerateArrays.unSorted(10);

        for (int i = 0; i < 10; i++) {
            System.out.print(testArray[i] + " ");
        }

        System.out.println(" ");
        InsertionSort.insertionSort(testArray);

        for (int i = 0; i < 10; i++) {
            System.out.print(testArray[i] + " ");
        }
    }
}