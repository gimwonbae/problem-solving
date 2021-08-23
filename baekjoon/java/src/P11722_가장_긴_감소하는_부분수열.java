import java.util.*;
import java.io.*;

public class P11722_가장_긴_감소하는_부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
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
            ans = Math.max(dp[i], ans);
        }
        System.out.print(ans);
    }
}
