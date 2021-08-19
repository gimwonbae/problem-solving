import java.util.*;
import java.io.*;

public class P12101_123더하기2 {
    static int N;
    static int K;
    static int cnt;
    static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cnt = 0 ;
        sb = new StringBuilder();

        dfs(0);
        System.out.println(-1);
    }
    public static void dfs(int sum){
        if (sum == N){
            cnt++;
            if (cnt == K){
                sb.setLength(sb.length() - 1);
                System.out.print(sb);
                System.exit(0);
            }
            return;
        }
        if (sum > N){
            return;
        }
        for (int i = 1; i <= 3; i++){
            sb.append(i).append('+');
            sum += i;
            dfs(sum);
            sum -= i;
            sb.setLength(sb.length() - 2);
        }
    }
}
