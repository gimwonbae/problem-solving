import java.util.*;
import java.io.*;

public class P11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++){
            int x = arr[i];
            for (int j = 0; j < i; j++){
                int y = arr[j];
                if (x > y) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
