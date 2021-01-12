import java.util.Scanner;

public class p1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                if (sum >= m){
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        if (ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}
