import java.io.*;
import java.util.*;

public class P14925_목장_건설하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R+1][C+1];

        for (int i = 1; i <= R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[R+1][C+1];
        int ans = 0;
        for (int i = 1; i <= R; i++){
            for (int j = 1;j <= C; j++){
                if (map[i][j] == 0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.print(ans);
    }
}
