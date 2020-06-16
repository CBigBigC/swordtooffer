package problem40;

import java.util.Random;

public class KthSmallest {
    public static void main(String[] args) throws Exception {
        int[] a = {1,5,7,2,3,6};
        findKth(a, 3);
    }
    private static void findKth(int[] data, int k) throws Exception {
        if(data == null || k <= 0){
            throw new Exception("invalid input");
        }
        int temp = partition(data, data.length, 0, data.length - 1);
        if(temp > k - 1){
            temp = partition(data, data.length, 0, temp);
        }else if(temp < k - 1){
            temp = partition(data, data.length, temp, data.length - 1);
        }
        for(int i = 0; i < k; i ++){
            System.out.println(data[i]);
        }
    }

    private static int partition(int[] data, int length, int start, int end) throws Exception {
        if(data == null || length <= 0 || start < 0 || end >= length){
            throw new Exception("invalid input");
        }
        swap(data, (new Random()).nextInt(end - start + 1) + start, start);
        int temp = data[start];
        while(end > start){
            while(data[end] > temp && end > start){
                end --;
            }
            if(end > start){
                swap(data, start, end);
                start ++;
            }
            while(data[start] < temp && start < end){
                start ++;
            }
            if(start < end){
                swap(data, start, end);
                end --;
            }
        }
        data[start] = temp;
        return start;
    }
    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
