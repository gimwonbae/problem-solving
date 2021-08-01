import java.util.*;
import java.io.*;

public class P17845_수강_과목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[W+1];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            for (int j = W; j >= w; j--){
                dp[j] = Math.max(dp[j], dp[j-w] + p);
            }
        }
        System.out.print(dp[W]);
    }
}
