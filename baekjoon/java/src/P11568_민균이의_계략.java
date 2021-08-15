import java.util.*;
import java.io.*;

public class P11568_민균이의_계략 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}
