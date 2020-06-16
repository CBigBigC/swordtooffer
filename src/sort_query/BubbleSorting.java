package sort_query;

public class BubbleSorting {
    public void sort(int[] input) {
        if (input == null) return;
        int len = input.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }

        }
    }
}
