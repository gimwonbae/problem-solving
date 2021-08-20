import java.io.*;

public class P13699_점화식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++){
            for (int j = 0; j <= i-1; j++){
                dp[i] += (dp[j] * dp[i-1-j]);
            }
        }
        System.out.print(dp[N]);
    }
}