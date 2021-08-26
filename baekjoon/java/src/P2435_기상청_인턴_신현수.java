import java.util.*;
import java.io.*;

public class P2435_기상청_인턴_신현수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        int ans = arr[K];
        for (int i = K+1; i <= N; i++){
            ans = Math.max(ans, arr[i] - arr[i-K]);
        }
        System.out.print(ans);
    }
}