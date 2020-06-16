package sort_query;

public class MergeSorting {
    public void sort(int[] input) {
        int[] result = mergeSort(input, 0, input.length - 1);
        for(int i = 0; i < input.length; i ++){
            input[i] = result[i];
        }
    }

    private int[] mergeSort(int[] input, int begin, int end) {
        if (begin >= end) return new int[]{input[begin]};
        int mid = begin + (end - begin) / 2;
        int[] leftPart = mergeSort(input, begin, mid);
        int[] rightPart = mergeSort(input, mid + 1, end);
        int[] result = new int[leftPart.length + rightPart.length];
        int count = 0, left = 0, right = 0;
        while (left < leftPart.length && right < rightPart.length) {
            result[count++] = leftPart[left] <= rightPart[right] ? leftPart[left++] : rightPart[right++];
        }
        while (left < leftPart.length) {
            result[count++] = leftPart[left++];
        }
        while (right < rightPart.length) {
             result[count++] = rightPart[right++];
        }
        return result;
    }
}
