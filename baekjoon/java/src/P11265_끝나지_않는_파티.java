import java.io.*;
import java.util.*;

public class P11265_끝나지_않는_파티 {
    static int N;
    static int M;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++){
            fw(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (graph[start-1][end-1] <= cost) sb.append("Enjoy other party\n");
            else sb.append("Stay here\n");
        }
        System.out.print(sb);
    }
    public static void fw(int i){
        for (int s = 0; s < N; s++){
            if (s != i){
                for (int e = 0; e < N; e++){
                    if (e != i){
                        graph[s][e] = Math.min(graph[s][e], graph[s][i] + graph[i][e]);
                    }
                }
            }
        }
    }
}
