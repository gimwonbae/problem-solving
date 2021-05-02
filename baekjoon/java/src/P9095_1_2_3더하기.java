import java.util.Scanner;

public class P9095_1_2_3더하기 {
    static int start = 4;
    static int[] arr = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            if (n > 3) {
                dp(n);
            }
            System.out.println(arr[n]);
        }
    }
    public static void dp(int n){
        for (int i = start; i <= n; i++){
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }
        start = n+1;
    }
}
