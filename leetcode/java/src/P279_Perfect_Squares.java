import java.util.*;

public class P279_Perfect_Squares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++){
            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
