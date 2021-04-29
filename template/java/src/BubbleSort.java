import java.util.*;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int N = arr.length;
        for (int i = 0; i < N-1; i++){
            for (int j = 0; j < N-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 2, 1, 2, 6, 10, 30, 20, 0, -3, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
