import java.util.*;

public class P11057_오르막수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dp(n)%10007);
    }
    static int dp(int n){
        int[][] arr = new int[n+1][10];
        for (int i = 0; i < 10; i++){
            arr[1][i] = 1;
        }
        for (int i = 2; i <= n; i++){
            arr[i][9] = 1;
            for (int j = 8; j >= 0; j--){
                arr[i][j] = arr[i][j+1] + arr[i-1][j];
                arr[i][j] %= 10007;
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++){
            ans += arr[n][i];
        }
        return ans;
    }
}