import java.util.Scanner;

public class P11659_구간합구하기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 2; i <= n; i++){
            arr[i] += arr[i-1];
        }
        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(arr[y] - arr[x-1]);
        }
    }
}
