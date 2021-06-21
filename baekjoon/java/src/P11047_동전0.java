import java.util.*;
import java.io.*;

public class P11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        while(K > 0){
            int coin = arr[N-1];
            ans += K / coin;
            K = K % coin;
            N--;
        }
        System.out.println(ans);
    }
}
