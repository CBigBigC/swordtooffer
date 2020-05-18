package problem21;

public class OddNumberFirst {
     public static void main(String[] args) {
          int a[] = {2,4,6,8,1,3,5,7,9};
          oddFirst(a);
          for(int i = 0; i < a.length; i ++){
               System.out.println(a[i]);
          }
     }
     private static void oddFirst(int[] input){
          if(input == null) return;
          int left = 0;
          int right = input.length - 1;
          while(left < right){
               if(input[left] % 2 == 0 && input[right] % 2 != 0){
                    swamp(input, left, right);
                    left ++;
                    right --;
               }else if(input[left] % 2 != 0){
                    while(left < right && input[left] % 2 != 0){
                         left ++;
                    }
               }else if(input[right] % 2 == 0){
                    while(left < right && input[right] % 2 == 0){
                         right --;
                    }
               }
          }
     }
     private static void swamp(int[] input, int left, int right){
          int temp = input[left];
          input[left] = input[right];
          input[right] = temp;
     }
}
