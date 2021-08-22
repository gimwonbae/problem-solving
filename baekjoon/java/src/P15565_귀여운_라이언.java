import java.util.*;
import java.io.*;

public class P15565_귀여운_라이언 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int cnt = 0;
        if (arr[0] == 1) cnt++;

        while (left <= right && right < N){
            if (cnt < K){
                right++;
                if (arr[right] == 1) cnt++;
            }
            else if (cnt == K){
                ans = Math.min(ans, right - left + 1);
                if (arr[left] == 1) cnt--;
                left++;
            }
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);
    }
}