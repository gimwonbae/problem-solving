import java.util.*;
import java.io.*;

public class P3304_최장_공통_부분_수열
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = br.readLine();
            String[] s_arr = s.split(" ");
            String s1 = s_arr[0];
            String s2 = s_arr[1];

            int ans = lcs(s1, s2);
            System.out.printf("#%d %d\n", test_case, ans);
        }
    }
    public static int lcs(String s1, String s2){
        int N = s1.length();
        int M = s2.length();
        int[][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++){
            char x = s1.charAt(i-1);
            for (int j = 1; j <= M; j ++){
                if (x == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[N][M];
    }
}