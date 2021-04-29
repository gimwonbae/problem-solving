import java.util.*;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        int N = arr.length;
        for (int i = 0; i < N-1; i++){
            int min = i;
            for (int j = i+1; j < N; j++){
                if (arr[j] < arr[min]) min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 2, 1, 2, 6, 10, 30, 20, 0, -3, 7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
