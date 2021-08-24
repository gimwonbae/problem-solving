import java.util.*;
import java.io.*;

public class P18353_병사_배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < N; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.print(N - ans);
    }
}
