import java.util.*;
import java.io.*;

public class P2948_문자열_교집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++){
            Set<String> nSet = new HashSet<>();
            Set<String> mSet = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                nSet.add(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++){
                mSet.add(st.nextToken());
            }
            int ans = 0;
            for (String x : nSet){
                if (mSet.contains(x)) ans++;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
