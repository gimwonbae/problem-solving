import java.util.*;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int N = arr.length;
        for (int i = 1; i < N; i++){
            int val = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > val){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 2, 1, 2, 6, 10, 30, 20, 0, -3, 7};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
