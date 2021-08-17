import java.util.*;
import java.io.*;

public class P13707_합분해2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        Arrays.fill(dp, 1);

        for (int i = 0; i < K-1; i++){
            for (int j = 1; j <= N; j++){
                dp[j] += dp[j-1];
                dp[j] %= 1000000000;
            }
        }
        System.out.print(dp[N]);
    }
}