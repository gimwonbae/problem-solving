import java.util.*;
import java.io.*;

public class P2458_키_순서 {
    static boolean[][] graph;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for (int k = 1; k <= N; k++){
            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++){
                    if (graph[i][k] && graph[k][j]) graph[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++){
            if (cnt(i)) ans++;
        }
        System.out.print(ans);
    }
    public static boolean cnt(int x){
        int high = 0;
        int low = 0;
        for (int i = 1; i <= N; i++){
            if (i == x) continue;
            if (graph[x][i]) high++;
            if (!graph[i][x]) low++;
        }
        if (low == high) return true;
        else return false;
    }
}