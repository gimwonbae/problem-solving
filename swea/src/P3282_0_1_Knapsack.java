import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3282_0_1_Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[] dp = new int[W+1];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                for (int j = W; j >= 0; j--){
                    if (j - w >= 0){
                        dp[j] = Integer.max(dp[j], dp[j-w] + p);
                    }
                }
            }
            System.out.printf("#%d %d\n", t, dp[W]);
        }
    }
}
