package sort_query;

public class ATest {
    public static void main(String[] args) {

        int[] input = {1,7,3,2};
//        BubbleSorting bubbleSorting = new BubbleSorting();
//        bubbleSorting.sort(input);
//        QuickSorting quickSorting = new QuickSorting();
//        quickSorting.quickSort(input, 0, input.length - 1);
        MergeSorting mergeSorting = new MergeSorting();
        mergeSorting.sort(input);
        printArray(input);
    }
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i ++){
            System.out.print(array[i] + " ");
        }
    }
    public static void computeArray(int[] array){
        array[0] = 100;
    }
}

