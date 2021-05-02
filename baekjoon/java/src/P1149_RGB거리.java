import java.util.Arrays;
import java.util.Scanner;

public class P1149_RGB거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < n; i++){
            arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        }
        Arrays.sort(arr[n-1]);
        System.out.println(arr[n-1][0]);
    }
}
