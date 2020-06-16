package problem38;

public class RangeOfString {
    public static void main(String[] args) {
        printAll("abca");
    }

    private static void printAll(String input){
        if(input == null) return;
        char[] array = input.toCharArray();
        if(array.length == 0) return;
        printAllCore(array, 0);
    }

    private static void printAllCore(char[] array, int begin) {
        int len = array.length;
        if(begin == len - 1){
            System.out.println(array);
        }
        for(int i = begin; i < len; i ++){
            char temp = array[begin];
            array[begin] = array[i];
            array[i] = temp;

            printAllCore(array, begin + 1);

            temp = array[begin];
            array[begin] = array[i];
            array[i] = temp;
        }
    }
}
