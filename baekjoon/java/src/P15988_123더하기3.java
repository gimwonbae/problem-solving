import java.util.*;
import java.io.*;

public class P15988_123더하기3 {
    static long[] dp;
    static int flag;
    public static void main(String[] args) throws IOException{
        dp = new long[1000001];

        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        flag = 3;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++){
            int x = Integer.parseInt(br.readLine());
            calc(x);
            sb.append(dp[x]).append("\n");
        }
        System.out.print(sb);
    }
    public static void calc(int x){
        for (int i = flag + 1; i <= x; i++){
            dp[i] = (dp[i] + dp[i-1]) % 1000000009;
            dp[i] = (dp[i] + dp[i-2]) % 1000000009;
            dp[i] = (dp[i] + dp[i-3]) % 1000000009;
        }
        flag = Math.max(flag, x);
    }
}
