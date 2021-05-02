import java.io.*;
import java.util.*;

public class P1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while(end <= n && start <= n){
            if (sum >= s){
                ans = Math.min(end - start, ans);
                sum -= arr[start];
                start++;
            } else {
                sum += arr[end];
                end++;
            }
        }
        if (ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}
