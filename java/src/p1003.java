import java.util.Scanner;

public class p1003 {
    static int[][] arr = new int[41][2];
    static int start = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        arr[0][0] = 1;
        arr[1][1] = 1;
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            if (n >= start){
                dp(n);
            }
            System.out.printf("%d %d\n", arr[n][0], arr[n][1]);
        }
    }
    public static void dp(int n){
        for (int i = start; i <= n; i++){
            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }
        start = n + 1;
    }
}
