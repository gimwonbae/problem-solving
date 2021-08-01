import java.util.*;
import java.io.*;

public class P19637_IF문_좀_대신_써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N];
        int[] flags = new int[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            flags[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            int x = Integer.parseInt(br.readLine());
            int ans = lower_bound(flags, x);

            sb.append(names[ans]).append("\n");
        }
        System.out.print(sb);
    }
    public static int lower_bound(int[] flags, int x){
        int left = 0;
        int right = flags.length - 1;
        int ans = right + 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if (flags[mid] >= x){
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return ans;
    }
}
